package com.entity.javaBrains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Vehicle {
    @Id
    @GeneratedValue
    private int vehicleId;
    private String vehicleName;
}
