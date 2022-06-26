package com.example.furama.service.impl;

import com.example.furama.model.CustomerType;
import com.example.furama.repository.ICustomerTypeRepository;
import com.example.furama.service.ICustomerTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    private final ICustomerTypeRepository iCustomerTypeRepository;

    public CustomerTypeService(ICustomerTypeRepository iCustomerTypeRepository) {
        this.iCustomerTypeRepository = iCustomerTypeRepository;
    }

    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }
}
