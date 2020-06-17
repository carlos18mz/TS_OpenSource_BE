package com.softper.ts.Resources.Outputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlanOutput {
    private int id;
    private String planName;
    private int durationDays;
    private double price;
    private double tax;

    public PlanOutput(int id, String planName, int durationDays, double price, double tax) {
        this.id = id;
        this.planName = planName;
        this.durationDays = durationDays;
        this.price = price;
        this.tax = tax;
    }
}
