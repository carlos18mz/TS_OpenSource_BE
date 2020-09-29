package com.softper.ts.Resources.Inputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentMethodInput {
    private String bankName;
    private int swiftCode;
    private long accountNumber;
    private int dni;


    public PaymentMethodInput(String bankName, int swiftCode, long accountNumber, int dni) {
        this.bankName = bankName;
        this.swiftCode = swiftCode;
        this.accountNumber = accountNumber;
        this.dni = dni;
    }

}
