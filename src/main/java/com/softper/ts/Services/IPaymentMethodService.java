package com.softper.ts.Services;

import com.softper.ts.Model.PaymentMethod;
import com.softper.ts.Resources.Comunications.PaymentMethodResponse;

public interface IPaymentMethodService extends ICrudService<PaymentMethod> {
    PaymentMethodResponse findPaymentMethodById(int paymentMethodId);
    PaymentMethodResponse findPaymentMethodByUserId(int userId);
}
