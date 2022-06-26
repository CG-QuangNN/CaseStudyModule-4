package com.example.furama.repository;

import com.example.furama.model.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAttachServiceRepository extends JpaRepository<AttachService, Integer> {
    @Query(value = "select attachServiceId from AttachService")
    List<Integer> findAllAttachServiceId();
}
