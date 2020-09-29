package com.softper.ts.Repositories;

import com.softper.ts.Model.Cargo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICargoRepository extends JpaRepository<Cargo , Integer> {

    @Query("select s from Cargo s where s.customer.id = (:uid)")
    List<Cargo> findCargoesByCustomerId(@Param("uid") Integer customerId);


}
