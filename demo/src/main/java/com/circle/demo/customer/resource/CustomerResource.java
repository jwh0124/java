package com.circle.demo.customer.resource;

import com.circle.demo.customer.domain.Customer;
import com.circle.demo.customer.domain.form.CustomerForm;
import com.circle.demo.customer.service.CustomerService;
import com.circle.demo.customer.service.LoginUserDetails;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerResource {

    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers/list";
    }

    @ModelAttribute
    CustomerForm setUpForm(){
        return new CustomerForm();
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Validated CustomerForm form, BindingResult result, Model model, @AuthenticationPrincipal LoginUserDetails userDetails) {
        if(result.hasErrors()){
            return list(model);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(form, customer);
        customerService.create(customer, userDetails.getUser());
        return "redirect:/customers";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable Integer id){
        return customerService.findOne(id);
    }

    @RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
    String editForm(@RequestParam Integer id, CustomerForm form) {
        Customer customer = customerService.findOne(id);
        BeanUtils.copyProperties(customer, form);
        return "customers/edit";
    }


    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@RequestParam Integer id, @Validated CustomerForm form, BindingResult result, @AuthenticationPrincipal LoginUserDetails userDetails){
        if(result.hasErrors()) {
            return editForm(id, form);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(form, customer);
        customer.setId(id);
        customerService.update(customer, userDetails.getUser());
        return "redirect:/customers";
    }

    @RequestMapping(value = "edit", params = "goToTop")
    String goToTop(){
        return "redirect:/customers";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    String edit(@RequestParam Integer id){
        customerService.delete(id);
        return "redirect:/customers";
    }

}
