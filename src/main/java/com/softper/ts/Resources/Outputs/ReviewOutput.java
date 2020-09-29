package com.softper.ts.Resources.Outputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReviewOutput {
    private String Customer;
    private String Driver;
    private String cargo;
    private String commentary;
    private double calification;

    public ReviewOutput(String customer, String driver, String cargo, String commentary, double calification) {
        Customer = customer;
        Driver = driver;
        this.cargo = cargo;
        this.commentary = commentary;
        this.calification = calification;
    }
}
