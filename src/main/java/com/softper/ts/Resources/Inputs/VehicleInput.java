package com.softper.ts.Resources.Inputs;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class VehicleInput {

    private int driverId;
    private String license;
    private String brand;
    private String model;
    private double loadingCapacity;
    private String ownershipCard;

    public VehicleInput(int driverId, String license, String brand, String model, double loadingCapacity, String ownershipCard) {
        this.driverId = driverId;
        this.license = license;
        this.brand = brand;
        this.model = model;
        this.loadingCapacity = loadingCapacity;
        this.ownershipCard = ownershipCard;
    }
}
