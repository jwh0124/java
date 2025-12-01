package com.example.jsonrelation.service.impl;

import com.example.jsonrelation.dto.DeviceDto;
import com.example.jsonrelation.mapper.DeviceMapper;
import com.example.jsonrelation.repository.DeviceRepository;
import com.example.jsonrelation.service.IDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceService implements IDeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;

    public DeviceService(DeviceRepository deviceRepository, DeviceMapper deviceMapper) {
        this.deviceRepository = deviceRepository;
        this.deviceMapper = deviceMapper;
    }

    @Override
    public List<DeviceDto> findAllDevices() {
        return deviceRepository.findAll().stream().map(deviceMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public DeviceDto findDeviceById(Long id) {
        return deviceRepository.findById(id).map(deviceMapper::toDto).orElse(null);
    }

    @Override
    public DeviceDto createDevice(DeviceDto deviceDto) {
        var device = deviceMapper.toEntity(deviceDto);

        return deviceMapper.toDto(deviceRepository.save(device));
    }

    @Override
    public DeviceDto updateDevice(Long id, DeviceDto deviceDto) {
        var device =  deviceMapper.toEntity(deviceDto);
        device = deviceRepository.save(device);

        return deviceMapper.toDto(device);
    }

    @Override
    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }
}
