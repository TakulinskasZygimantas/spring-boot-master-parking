package com.zygtak.springbootmasterparking.service;

import com.zygtak.springbootmasterparking.entity.Device;
import com.zygtak.springbootmasterparking.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository repository;

    public Device saveDevice(Device device) {
        return repository.save(device);
    }

    public Device getDeviceById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Device getDeviceByMac(String mac) {
        return repository.findByMac(mac);
    }

    public List<Device> getAllDevicesByUserId(int userId) {
        return repository.findAllByUserId(userId);
    }

    public String deleteDevice(int id) {
        repository.deleteById(id);
        return "Device " + id + " removed";
    }

    public Device updateDevice(Device device) {
        Device existingDevice = repository.findById(device.getId()).orElse(null);
        existingDevice.setMac(device.getMac());
        existingDevice.setName(device.getName());
        existingDevice.setStatus(device.getStatus());
        existingDevice.setUserId(device.getUserId());
        return repository.save(existingDevice);
    }
}