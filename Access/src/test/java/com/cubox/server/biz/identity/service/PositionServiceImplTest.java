package com.cubox.server.biz.identity.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.UUID;

import com.cubox.server.biz.identity.entity.Position;
import com.cubox.server.biz.identity.repository.PositionRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class PositionServiceImplTest {
    
    @Autowired
    private PositionService _service;

    @Autowired
    private PositionRepository _repository;

    private UUID id = UUID.randomUUID(); 

    @BeforeEach
    public void setUp(){
        _repository.save(new Position(id,"position", "position"));
    }

    @AfterEach
    public void tearDown(){
        _repository.deleteAll();
    }

    @Test
    public void retrievePositionList() throws Exception {
        // given

        // when
        List<Position> positionList = _service.retrievePositionList();

        // then
        assertEquals(1, positionList.size());
    }

    @Test
    @Disabled("TODO : Fixed Test Case")
    public void retrievePosition() throws Exception {
        // given

        // when
        Position position = _service.retrievePosition(id);
        // then
        assertNotNull(position);
    }
}
