package com.softper.ts.Resources.Inputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConfigurationInput {
    private String language;
    private String paymentCurrency;

    public ConfigurationInput(String language, String paymentCurrency) {
        this.language = language;
        this.paymentCurrency = paymentCurrency;
    }
}
