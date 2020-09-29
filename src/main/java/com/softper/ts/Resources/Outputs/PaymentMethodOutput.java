package com.softper.ts.Resources.Outputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentMethodOutput {
    private String bankName;
    private int swiftCode;
    private long accountNumber;
    private int dni;


    public PaymentMethodOutput(String bankName, int swiftCode, long accountNumber, int dni) {
        this.bankName = bankName;
        this.swiftCode = swiftCode;
        this.accountNumber = accountNumber;
        this.dni = dni;
    }
}
