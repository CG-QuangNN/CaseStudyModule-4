package com.example.furama.service.impl;

import com.example.furama.model.Contract;
import com.example.furama.repository.IContractRepository;
import com.example.furama.service.IContractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    private final IContractRepository iContractRepository;

    public ContractService(IContractRepository iContractRepository) {
        this.iContractRepository = iContractRepository;
    }


    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public Contract save(Contract contract) {
        return iContractRepository.save(contract);
    }

    @Override
    public void delete(Integer contractId) {
        iContractRepository.deleteById(contractId);
    }

    @Override
    public List<Integer> findAllContractId() {
        return iContractRepository.findAllContractId();
    }
}
