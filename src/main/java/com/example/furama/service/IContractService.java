package com.example.furama.service;

import com.example.furama.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    Contract save(Contract customer);

    void delete(Integer contractId);

    List<Integer> findAllContractId();
}
