package com.cubox.server.biz.log.repository;

import java.util.UUID;

import com.cubox.server.biz.log.entity.AccessHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessHistoryRepository extends JpaRepository<AccessHistory, UUID>{
    
}
