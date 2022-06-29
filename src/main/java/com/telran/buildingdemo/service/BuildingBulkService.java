package com.telran.buildingdemo.service;

import com.telran.buildingdemo.dto.BuildingBulkRequestDTO;

import java.util.List;

public interface BuildingBulkService {

    void createBuildingsBulk(List<BuildingBulkRequestDTO> buildings);
}
