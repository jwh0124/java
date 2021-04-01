package com.cubox.server.biz.log.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.cubox.server.biz.log.entity.AccessHistory;
import com.cubox.server.biz.log.repository.AccessHistoryRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class AccessHistoryServiceImplTest {

    @Autowired
    private AccessHistoryService _service;

    @Autowired
    private AccessHistoryRepository _repository;

    private UUID id = UUID.randomUUID();

    @BeforeEach
    public void setUp() {
        _repository.save(new AccessHistory(id, "ST", "Admin" ,"Access", "Card", LocalDateTime.now()));
    }

    @AfterEach
    public void tearDown() {
        _repository.deleteAll();
    }

    @Test
    public void retrieveAccessHistoryList() throws Exception {
        
        // given
        
        // when
        List<AccessHistory> accessHistoryList = _service.retrieveAccessHistoryList();

        // then
        assertEquals(1, accessHistoryList.size());
    }

    @Test
    public void retrieveAccessHistory() throws Exception{
        
        
        // given

        // when
        AccessHistory accessHistory = _service.retrieveAccessHistory(id);

        // then
        assertNotNull(accessHistory);
    }
}
