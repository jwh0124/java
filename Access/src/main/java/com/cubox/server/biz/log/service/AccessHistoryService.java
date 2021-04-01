package com.cubox.server.biz.log.service;

import java.util.List;
import java.util.UUID;

import com.cubox.server.biz.log.entity.AccessHistory;

public interface AccessHistoryService {

    List<AccessHistory> retrieveAccessHistoryList();

    AccessHistory retrieveAccessHistory(UUID id);
}
