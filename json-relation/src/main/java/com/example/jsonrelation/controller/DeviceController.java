package com.example.jsonrelation.controller;

import com.example.jsonrelation.dto.DeviceDto;
import com.example.jsonrelation.service.impl.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/devices")
    public ResponseEntity<List<DeviceDto>> getAllDevices() {

        var devices = deviceService.findAllDevices();

        return ResponseEntity.ok().body(devices);
    }

    @GetMapping("/devices/{id}")
    public ResponseEntity<DeviceDto> getDeviceById(@PathVariable Long id) {

        var device = deviceService.findDeviceById(id);

        if (device == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(device);
    }

    @PostMapping("/devices")
    public ResponseEntity<DeviceDto> createDevice(@RequestBody DeviceDto deviceDto) {
        var createdDevice = deviceService.createDevice(deviceDto);
        return ResponseEntity.ok().body(createdDevice);
    }

    @PutMapping("/devices/{id}")
    public ResponseEntity<DeviceDto> updateDevice(@PathVariable Long id, @RequestBody DeviceDto deviceDto) {
        var updatedDevice = deviceService.updateDevice(id, deviceDto);
        if (updatedDevice == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedDevice);
    }

    @DeleteMapping("/devices/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }
}
