package com.circle.demo.customer.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginResource {

    @RequestMapping("loginForm")
    String loginForm() {
        return "loginForm";
    }
}
