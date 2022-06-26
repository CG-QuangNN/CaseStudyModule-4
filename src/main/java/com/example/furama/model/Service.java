package com.example.furama.model;

import com.example.furama.dto.ServiceIdCodeDto;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int serviceId;
    private String serviceCode;
    private String serviceName;
    private Integer serviceArea;
    private Double serviceCost;
    private Integer serviceMaxPeople;
    @ManyToOne
    @JoinColumn(name = "rent_type_id")
    private RentType rentType;
    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;
    private String freeServiceIncluded;

    public ServiceIdCodeDto mapToServiceIdCodeDto() {
        return ServiceIdCodeDto.builder()
                .serviceId(this.getServiceId())
                .serviceCode(this.getServiceCode())
                .build();
    }
}
