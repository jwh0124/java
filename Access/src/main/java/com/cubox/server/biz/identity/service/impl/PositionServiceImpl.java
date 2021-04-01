package com.cubox.server.biz.identity.service.impl;

import java.util.List;
import java.util.UUID;

import com.cubox.server.biz.identity.entity.Position;
import com.cubox.server.biz.identity.repository.PositionRepository;
import com.cubox.server.biz.identity.service.PositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {

    private PositionRepository _positionRepository; 

    @Override
    public List<Position> retrievePositionList() {
        return _positionRepository.findAll();
    }

    @Override
    public Position retrievePosition(UUID id) {
        return _positionRepository.findById(id).orElse(null);
    }

    @Override
    public void registerPosition(Position position) {
        _positionRepository.save(position);
    }

    @Override
    public void modifyPosition(UUID id, Position position) {        
        if(_positionRepository.existsById(id)){
            position.setId(id);
            _positionRepository.save(position);
        }        
    }

    @Override
    public void removePosition(UUID id) {
        if(_positionRepository.existsById(id)){
            _positionRepository.deleteById(id);
        }
    }
    
    @Autowired
    public void setPositionRepository(PositionRepository positionRepository) {
        this._positionRepository = positionRepository;
    }
}
