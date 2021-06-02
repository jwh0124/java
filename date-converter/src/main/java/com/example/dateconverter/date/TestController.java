package com.example.dateconverter.date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private TestService service;

    @GetMapping
    public List<TestEntity> getList() {
        return service.getList();
    }

    @GetMapping(value = { "/{id}" })
    public TestEntity get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public Long post(@RequestBody TestEntity test) {
        return service.post(test);
    }
}
