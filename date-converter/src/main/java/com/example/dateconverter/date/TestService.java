package com.example.dateconverter.date;

import java.util.List;

public interface TestService {
    List<TestEntity> getList();

    TestEntity get(Long id);

    Long post(TestEntity test);
}
