package com.softper.ts.Model;

import java.util.ArrayList;
import java.util.List;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "services_requests")
@EntityListeners(AuditingEntityListener.class)
@Data @NoArgsConstructor
public class ServiceRequest implements Serializable {

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "servicesRequest")
    private List<Service> servicesList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

}