package com.example.furama.service.impl;

import com.example.furama.repository.IEmployeeRepository;
import com.example.furama.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository iEmployeeRepository;

    public EmployeeService(IEmployeeRepository iEmployeeRepository) {
        this.iEmployeeRepository = iEmployeeRepository;
    }

    @Override
    public List<Integer> findAllEmployeeId() {
        return iEmployeeRepository.findAllEmployeeId();
    }
}
