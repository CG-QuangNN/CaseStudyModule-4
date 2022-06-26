package com.example.furama.repository;

import com.example.furama.dto.ServiceIdCodeDto;
import com.example.furama.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IServiceRepository extends JpaRepository<Service, Integer> {
    @Query("SELECT new com.example.furama.dto.ServiceIdCodeDto(serviceId, serviceCode) FROM Service")
    List<ServiceIdCodeDto> findAllServiceIdCode();
}
