package com.softper.ts.Repositories;

import com.softper.ts.Model.Vehicle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {
    @Query("select s from Vehicle s where s.driver.id = (:uid)")
    List<Vehicle> getVehiclesByDriverId(@Param("uid") Integer driverId);
}
