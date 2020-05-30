package com.softper.ts.Repositories;

import com.softper.ts.Model.Service;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IServiceRepository extends JpaRepository<Service, Integer> {

    @Query("select s from Service s where s.servicesRequest.driver.id = (:driverId)")
    List<Service> findServicesByDriverId(@Param("driverId")int driverId);
}
