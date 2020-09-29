package com.softper.ts.Resources.Comunications;

import com.softper.ts.Resources.Outputs.PaymentMethodOutput;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class PaymentMethodResponse extends BaseResponse<PaymentMethodOutput> {
    public PaymentMethodResponse(String message) {super(message);}
    public PaymentMethodResponse(PaymentMethodOutput paymentMethodOutput) {super(paymentMethodOutput);}
    public PaymentMethodResponse(List<PaymentMethodOutput> paymentMethodOutputList) {super(paymentMethodOutputList);}
}
