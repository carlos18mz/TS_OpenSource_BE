package com.softper.ts.Resources.Outputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ConfigurationOutput {
    private String userName;
    private String language;
    private String paymentCurrency;

    public ConfigurationOutput(String userName, String language, String paymentCurrency) {
        this.userName = userName;
        this.language = language;
        this.paymentCurrency = paymentCurrency;
    }
}
