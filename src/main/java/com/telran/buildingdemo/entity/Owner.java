package com.telran.buildingdemo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "owner")

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;
}
