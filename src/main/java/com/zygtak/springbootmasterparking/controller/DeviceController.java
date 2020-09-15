package com.zygtak.springbootmasterparking.controller;

import com.zygtak.springbootmasterparking.entity.Device;
import com.zygtak.springbootmasterparking.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceController {

    @Autowired
    private DeviceService service;

    @PostMapping("/addDevice")
    public Device addDevice(@RequestBody Device device) {
        return service.saveDevice(device);
    }

    @GetMapping("/deviceById/{id}")
    public Device getDeviceById(@PathVariable int id) {
        return service.getDeviceById(id);
    }

    @GetMapping("/allDevicesByUserId/{userId}")
    public List<Device> getAllDevices(@PathVariable int userId) {
        return service.getAllDevicesByUserId(userId);
    }

    @PutMapping("/updateDevice")
    public Device updateDevice(@RequestBody Device device) {
        return service.updateDevice(device);
    }

    @DeleteMapping("/deleteDevice/{id}")
    public String deleteDevice(@PathVariable int id) {
        return service.deleteDevice(id);
    }
}