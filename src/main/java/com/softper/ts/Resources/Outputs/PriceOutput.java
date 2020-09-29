package com.softper.ts.Resources.Outputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PriceOutput {
    private double totalPrice;
    private double tax;
    private String priceFrom;

    public PriceOutput(double totalPrice, double tax, String priceFrom) {
        this.totalPrice = totalPrice;
        this.tax = tax;
        this.priceFrom = priceFrom;
    }
}
