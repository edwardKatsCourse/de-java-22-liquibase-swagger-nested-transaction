package com.telran.buildingdemo.service.impl;

import com.telran.buildingdemo.dto.ApartmentBulkRequestDTO;
import com.telran.buildingdemo.entity.Apartment;
import com.telran.buildingdemo.entity.Building;
import com.telran.buildingdemo.entity.Owner;
import com.telran.buildingdemo.repository.ApartmentRepository;
import com.telran.buildingdemo.repository.OwnerRepository;
import com.telran.buildingdemo.service.ApartmentOwnerBulkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApartmentOwnerBulkServiceImpl implements ApartmentOwnerBulkService {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    // @transactional
    // |building service -> | apartment service |


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createApartmentAndOwners(ApartmentBulkRequestDTO apartmentDTO, Building building) {
        var apartment = Apartment.builder()
                .building(building)
                .build();
        apartmentRepository.save(apartment);
        var ownersDTO = apartmentDTO.getOwners();

        if (ownersDTO == null || ownersDTO.isEmpty()) {
            return;
        }
        ownersDTO
                .forEach(ownerDTO -> {
                    var owner = Owner.builder()
                            .apartment(apartment)
                            .name(ownerDTO.getName())
                            .build();

                    ownerRepository.save(owner);
                });
    }
}
