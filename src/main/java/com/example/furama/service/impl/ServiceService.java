package com.example.furama.service.impl;

import com.example.furama.dto.ServiceIdCodeDto;
import com.example.furama.repository.IServiceRepository;
import com.example.furama.service.IServiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService {
    private final IServiceRepository iServiceRepository;

    public ServiceService(IServiceRepository iServiceRepository) {
        this.iServiceRepository = iServiceRepository;
    }

    @Override
    public List<ServiceIdCodeDto> findAllServiceIdCode() {
        return iServiceRepository.findAllServiceIdCode();
    }
}
