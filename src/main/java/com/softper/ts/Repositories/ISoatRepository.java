package com.softper.ts.Repositories;

import com.softper.ts.Model.Soat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoatRepository extends JpaRepository<Soat, Integer> {
}
