package com.softper.ts.Resources.Outputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ConfigurationOutput {
    private String userName;
    private String language;
    private String paymentCurrency;
}
