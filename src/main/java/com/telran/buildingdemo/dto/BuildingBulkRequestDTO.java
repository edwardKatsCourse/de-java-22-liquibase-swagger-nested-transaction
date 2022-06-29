package com.telran.buildingdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BuildingBulkRequestDTO {

    private String street;
    private String houseNumber;
    private List<ApartmentBulkRequestDTO> apartments;
}
