package com.cubox.server.biz.log.service.impl;

import java.util.List;
import java.util.UUID;

import com.cubox.server.biz.log.entity.AccessHistory;
import com.cubox.server.biz.log.repository.AccessHistoryRepository;
import com.cubox.server.biz.log.service.AccessHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessHistoryServiceImpl implements AccessHistoryService {

    private AccessHistoryRepository _accessHistoryRepository;

    @Override
    public List<AccessHistory> retrieveAccessHistoryList() {
        return _accessHistoryRepository.findAll();
    }

    @Override
    public AccessHistory retrieveAccessHistory(final UUID id) {
        return _accessHistoryRepository.findById(id).orElse(null);
    }
    
    @Autowired
    public void setAccessHistoryRepository(final AccessHistoryRepository accessHistoryRepository) {
        this._accessHistoryRepository = accessHistoryRepository;
    }
}
