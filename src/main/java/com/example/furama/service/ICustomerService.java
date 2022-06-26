package com.example.furama.service;

import com.example.furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllBySearch(String search, Pageable pageable);

    Customer save(Customer customer);

    void delete(Integer customerId);

    Optional<Customer> findById(Integer customerId);

    List<Integer> findAllCustomerId();

//    Customer update(Customer customer);
}
