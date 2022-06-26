package com.example.furama.service.impl;

import com.example.furama.repository.IAttachServiceRepository;
import com.example.furama.service.IAttachServiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceService implements IAttachServiceService {
    private final IAttachServiceRepository iAttachServiceRepository;

    public AttachServiceService(IAttachServiceRepository iAttachServiceRepository) {
        this.iAttachServiceRepository = iAttachServiceRepository;
    }

    @Override
    public List<Integer> findAllAttachServiceId() {
        return iAttachServiceRepository.findAllAttachServiceId();
    }
}
