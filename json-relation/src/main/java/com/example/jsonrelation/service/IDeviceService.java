package com.example.jsonrelation.service;

import com.example.jsonrelation.dto.DeviceDto;

import java.util.List;

public interface IDeviceService {

    List<DeviceDto> findAllDevices();

    DeviceDto findDeviceById(Long id);

    DeviceDto createDevice(DeviceDto deviceDto);

    DeviceDto updateDevice(Long id, DeviceDto deviceDto);

    void deleteDevice(Long id);
}
