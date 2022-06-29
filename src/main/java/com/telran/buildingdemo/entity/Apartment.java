package com.telran.buildingdemo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "apartment")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

}
