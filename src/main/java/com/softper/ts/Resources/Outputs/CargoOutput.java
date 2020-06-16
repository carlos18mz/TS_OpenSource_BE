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
}
