package com.cubox.server.biz.identity.repository;

import java.util.UUID;

import com.cubox.server.biz.identity.entity.Position;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, UUID>{
        
}