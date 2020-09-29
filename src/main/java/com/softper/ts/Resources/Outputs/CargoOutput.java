package com.softper.ts.Resources.Outputs;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CargoOutput {
    private String customer;
    private String driver;
    private int serviceId;
    private Date startTime;
    private Date finishTime;
    private double weight;
    private String description;
    private double servicePrice;
    private String cargoType;
    private String cargoStatus;

    public CargoOutput(String customer, String driver, int serviceId, Date startTime, Date finishTime, double weight, String description, double servicePrice, String cargoType, String cargoStatus) {
        this.customer = customer;
        this.driver = driver;
        this.serviceId = serviceId;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.weight = weight;
        this.description = description;
        this.servicePrice = servicePrice;
        this.cargoType = cargoType;
        this.cargoStatus = cargoStatus;
    }
}
