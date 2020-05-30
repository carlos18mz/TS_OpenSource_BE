package com.softper.ts.Repositories;

import com.softper.ts.Model.Plan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanRepository extends JpaRepository<Plan, Integer> {

    @Query("select p from Plan p where p.price.totalPrice = (:price)")
    List<Plan> findPlansByPriceValue(@Param("price") double priceValue);

    @Query("select p from Plan p where p.price.totalPrice > (:price)")
    List<Plan> findPlansHigherThanPriceValue(@Param("price") double priceValue);

    @Query("select p from Plan p where p.price.totalPrice < (:price)")
    List<Plan> findPlansLessThanPriceValue(@Param("price") double priceValue);
}

