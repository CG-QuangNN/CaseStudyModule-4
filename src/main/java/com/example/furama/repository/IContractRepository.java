package com.example.furama.repository;

import com.example.furama.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select contractId from Contract")
    List<Integer> findAllContractId();
}
