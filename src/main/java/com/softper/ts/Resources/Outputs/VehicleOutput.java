package com.softper.ts.Resources.Outputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VehicleOutput {
    private String driver;
    private String model;
    private String brand;
    private double loadingCapacity;

    public VehicleOutput(String driver, String model, String brand, double loadingCapacity) {
        this.driver = driver;
        this.model = model;
        this.brand = brand;
        this.loadingCapacity = loadingCapacity;
    }
}
