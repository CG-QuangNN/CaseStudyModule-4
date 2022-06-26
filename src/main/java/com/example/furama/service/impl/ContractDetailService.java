package com.example.furama.service.impl;

import com.example.furama.model.ContractDetail;
import com.example.furama.repository.IContractDetailRepository;
import com.example.furama.service.IContractDetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {
    private final IContractDetailRepository iContractDetailRepository;

    public ContractDetailService(IContractDetailRepository iContractDetailRepository) {
        this.iContractDetailRepository = iContractDetailRepository;
    }

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return iContractDetailRepository.findAll(pageable);
    }

    @Override
    public ContractDetail save(ContractDetail contractDetail) {
        return iContractDetailRepository.save(contractDetail);
    }

    @Override
    public void delete(Integer contractDetailId) {
        iContractDetailRepository.deleteById(contractDetailId);
    }
}
