package com.telran.buildingdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApartmentBulkRequestDTO {

    private boolean hasBalcony;
    private List<OwnerBulkRequestDTO> owners;
}
