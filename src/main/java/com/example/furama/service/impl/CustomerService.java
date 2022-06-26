package com.example.furama.service.impl;

import com.example.furama.model.Customer;
import com.example.furama.repository.ICustomerRepository;
import com.example.furama.service.ICustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository iCustomerRepository;

    public CustomerService(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }


    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllBySearch(String search, Pageable pageable) {
        return iCustomerRepository.findAllBySearch("%" + (search == null ? "" : search) + "", pageable);
    }

    @Override
    public Customer save(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    @Override
    public void delete(Integer customerId) {
        iCustomerRepository.deleteById(customerId);
    }

    @Override
    public Optional<Customer> findById(Integer customerId) {
        return iCustomerRepository.findById(customerId);
    }

    @Override
    public List<Integer> findAllCustomerId() {
        return iCustomerRepository.findAllCustomerId();
    }

//    @Override
//    public Customer update(Customer customer) {
//        return iCustomerRepository.;
//    }
}
