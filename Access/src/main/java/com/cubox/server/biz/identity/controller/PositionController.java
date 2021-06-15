package com.cubox.server.biz.identity.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.cubox.server.biz.identity.entity.Position;
import com.cubox.server.biz.identity.model.PositionDTO;
import com.cubox.server.biz.identity.service.PositionService;
import com.cubox.server.common.exception.ResourceNotFound;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/positions")
public class PositionController {
    
    private PositionService _positionService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<PositionDTO> getPositionList() throws Exception {
        
        return _positionService.retrievePositionList()
                .stream()
                .map(position -> modelMapper.map(position, PositionDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "{id}")
    public PositionDTO getPosition(@PathVariable UUID id, @RequestParam(value = "name") String name) throws Exception {
        try {
            Position position = _positionService.retrievePosition(id);
        
            if (position == null)
                throw new ResourceNotFound("Position Not Found...");

            if (position.getName().equals(name)) {
                System.out.println("Equals");
            }
            return modelMapper.map(position, PositionDTO.class);
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping
    public void postPosition(@RequestBody PositionDTO position) throws Exception {
        _positionService.registerPosition(modelMapper.map(position, Position.class));
    }

    @PutMapping(path = "{id}")
    public void putPosition(@PathVariable UUID id, @RequestBody PositionDTO position) throws Exception {
        _positionService.modifyPosition(id, modelMapper.map(position, Position.class));
    }

    @DeleteMapping(path = "{id}")
    public void deletePosition(@PathVariable UUID id) throws Exception {
        _positionService.removePosition(id);
    }

    @Autowired
    public void setPositionService(PositionService positionService) {
        this._positionService = positionService;
    }
}
