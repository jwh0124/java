package com.example.dateconverter.date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository repository;

    @Override
    public List<TestEntity> getList() {
        return repository.findAll();
    }

    @Override
    public TestEntity get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Long post(TestEntity test) {
        TestEntity save = repository.save(test);
        return save.getId();
    }

}
