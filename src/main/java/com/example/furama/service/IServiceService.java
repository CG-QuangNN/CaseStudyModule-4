package com.example.furama.service;

import com.example.furama.dto.ServiceIdCodeDto;

import java.util.List;

public interface IServiceService {
    List<ServiceIdCodeDto> findAllServiceIdCode();
}
