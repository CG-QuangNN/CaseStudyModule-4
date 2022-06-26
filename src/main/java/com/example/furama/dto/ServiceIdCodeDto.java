package com.example.furama.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ServiceIdCodeDto {
    private int serviceId;
    private String serviceCode;
}
