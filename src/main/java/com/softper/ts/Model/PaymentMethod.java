package com.softper.ts.Model;


import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "payment_methods")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class PaymentMethod implements Serializable {
    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bank_name", nullable = false)
    private String BankName;

    @Column(name = "swift_code", nullable = false)
    private int swiftCode;

    @Column(name = "bank_account_type", nullable = false)
    private String bankAccountType;

    @Column(name = "account_number", nullable = false)
    private long accountNumber;

    @Column(name = "dni", nullable = false)
    private int dni;

    @Column(name = "billing_adress", nullable = false)
    private String billingAdress;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @OneToOne
    @JoinColumn(name = "configuration_id")
    public Configuration configuration;
}
