package com.telran.buildingdemo.repository;

import com.telran.buildingdemo.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
