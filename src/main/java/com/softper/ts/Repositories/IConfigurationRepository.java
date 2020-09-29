package com.softper.ts.Repositories;

import com.softper.ts.Model.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConfigurationRepository extends JpaRepository<Configuration, Integer> {


}
