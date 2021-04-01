package com.cubox.server.biz.identity.service;

import java.util.List;
import java.util.UUID;

import com.cubox.server.biz.identity.entity.Position;

public interface PositionService {
    List<Position> retrievePositionList();

    Position retrievePosition(UUID id);

    void registerPosition(Position position);

    void modifyPosition(UUID id, Position position);

    void removePosition(UUID id);    
}
