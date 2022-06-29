package com.telran.buildingdemo.repository;

import com.telran.buildingdemo.entity.Apartment;
import com.telran.buildingdemo.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    @Query("delete from Apartment a where a.id in (:buildings)")
    @Modifying
    void deleteAllByBuilding_IdIn(@Param("buildings") List<Long> buildings);
}
