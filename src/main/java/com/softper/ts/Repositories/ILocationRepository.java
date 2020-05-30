package com.softper.ts.Repositories;

import com.softper.ts.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocationRepository extends JpaRepository<Location, Integer> {
}
