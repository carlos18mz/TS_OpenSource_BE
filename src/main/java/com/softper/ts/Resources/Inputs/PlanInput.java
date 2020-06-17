package com.softper.ts.Resources.Inputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlanInput {
    private String planName;
    private int durationDays;
    private double price;

    public PlanInput(String planName, int durationDays, double price) {
        this.planName = planName;
        this.durationDays = durationDays;
        this.price = price;
    }
}
