package com.telran.buildingdemo.service.impl;

import com.telran.buildingdemo.dto.BuildingBulkRequestDTO;
import com.telran.buildingdemo.entity.Apartment;
import com.telran.buildingdemo.entity.Building;
import com.telran.buildingdemo.entity.Owner;
import com.telran.buildingdemo.repository.ApartmentRepository;
import com.telran.buildingdemo.repository.BuildingRepository;
import com.telran.buildingdemo.repository.OwnerRepository;
import com.telran.buildingdemo.service.ApartmentOwnerBulkService;
import com.telran.buildingdemo.service.BuildingBulkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuildingBulkServiceImpl implements BuildingBulkService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private ApartmentOwnerBulkService apartmentOwnerBulkService;


    // open
    // save() -> building
    //      open
    //          apartment <- building
    //          owners
    //      commit
    //      select * from apartment ..
    // commit

    // select * from ...


    @Override
    @Transactional
    public void createBuildingsBulk(List<BuildingBulkRequestDTO> buildings) {
        buildings.stream()
                .filter(x -> !buildingRepository.existsByStreetAndHouseNumber(x.getStreet(), x.getHouseNumber()))
                .forEach(buildingDTO -> {
                    Building building = Building.builder()
                            .street(buildingDTO.getStreet())
                            .houseNumber(buildingDTO.getHouseNumber())
                            .build();
                    buildingRepository.save(building);

                    // nested transaction
                    var apartmentsDTO = buildingDTO.getApartments();
                    if (apartmentsDTO == null || apartmentsDTO.isEmpty()) {
                        return;
                    }

                    apartmentsDTO
                            .forEach(apartmentDTO -> {

                                try {
                                    apartmentOwnerBulkService.createApartmentAndOwners(apartmentDTO, building);
                                } catch (Exception e) {
                                    System.err.println("Error creating apartment or owner");
                                }
                            });


                });
    }
}
