package com.softper.ts.Repositories;

import com.softper.ts.Model.Price;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPriceRepository extends JpaRepository<Price, Integer> {

    @Query("select p from Price p where p.priceType = (:ptype)")
    List<Price> findPricesByType(@Param("ptype")int priceType);
}
