package com.softper.ts.ServicesImp;

import com.softper.ts.Model.Location;
import com.softper.ts.Resources.Comunications.CustomerResponse;
import com.softper.ts.Resources.Comunications.DriverResponse;
import com.softper.ts.Resources.Outputs.DriverOutput;
import com.softper.ts.Services.IDriverService;
import com.softper.ts.Model.Driver;
import com.softper.ts.Repositories.IDriverRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DriverService implements IDriverService{

    @Override
    public DriverResponse findNearDrivers(Location location) {
        return null;
    }

    @Override
    public DriverResponse findDriverById(int driverId) {
        return null;
    }

    @Override
    public DriverResponse getAllDrivers() {
        return null;
    }

    @Override
    public Driver save(Driver driver) throws Exception {
        return null;
    }

    @Override
    public void deleteById(Integer id) throws Exception {

    }

    @Override
    public Optional<Driver> findById(Integer id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Driver> findAll() throws Exception {
        return null;
    }
}
