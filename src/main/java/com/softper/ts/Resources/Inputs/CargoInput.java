package com.softper.ts.Resources.Inputs;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CargoInput implements Serializable {
    private double weight;
    private String description;
    private int servicePrice;
    private int serviceId;

}
