package com.example.furama.service;

import com.example.furama.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);

    ContractDetail save(ContractDetail contractDetail);

    void delete(Integer contractDetailId);
}
