package com.example.furama.repository;

import com.example.furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where customer_name like :customer_name", nativeQuery = true)
    Page<Customer> findAllBySearch(@Param("customer_name") String customerName, Pageable pageable);

    @Query(value = "select customerId from Customer")
    List<Integer> findAllCustomerId();
}
