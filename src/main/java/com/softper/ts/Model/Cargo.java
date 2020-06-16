package com.softper.ts.Model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cargoes")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Cargo implements Serializable {

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serviceId")
    private Service service;

    @Column(name = "weight")
    private double weight;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToOne
    @JoinColumn(name = "price")
    private Price price;

    @Column(name = "cargo_status")
    private String cargoStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo_type")
    private CargoType cargoType;

    @OneToOne(mappedBy = "cargo")
    private Location location;

    @OneToOne(mappedBy = "cargo", cascade = CascadeType.ALL)
    private Review review;


}
