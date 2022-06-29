package com.telran.buildingdemo.service;

import com.telran.buildingdemo.dto.ApartmentBulkRequestDTO;
import com.telran.buildingdemo.entity.Building;

public interface ApartmentOwnerBulkService {

    void createApartmentAndOwners(ApartmentBulkRequestDTO apartmentDTO, Building building);
}
