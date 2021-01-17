package com.zygtak.springbootmasterparking.repository;

import com.zygtak.springbootmasterparking.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
    Device findByMac(String mac);

    List<Device> findAllByUserId(int userId);
}