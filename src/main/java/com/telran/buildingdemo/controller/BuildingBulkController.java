package com.telran.buildingdemo.controller;

import com.telran.buildingdemo.dto.BuildingBulkRequestDTO;
import com.telran.buildingdemo.service.BuildingBulkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuildingBulkController {

    @Autowired
    private BuildingBulkService buildingBulkService;

    @PostMapping("/buildings/bulk")
    public void createBuildingsBulk(@RequestBody List<BuildingBulkRequestDTO> request) {
        buildingBulkService.createBuildingsBulk(request);
    }
}
