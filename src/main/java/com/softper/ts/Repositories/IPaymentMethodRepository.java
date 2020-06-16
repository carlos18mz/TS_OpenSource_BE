package com.softper.ts.Repositories;

import com.softper.ts.Model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {

}
