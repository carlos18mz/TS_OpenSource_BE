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

    @Autowired
    IDriverRepository driverRepository;


    @Override
    public Driver save(Driver driver) throws Exception {
        return driverRepository.save(driver);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        driverRepository.deleteById(id);
    }

    @Override
    public Optional<Driver> findById(Integer id) throws Exception {
        return driverRepository.findById(id);
    }

    @Override
    public List<Driver> findAll() throws Exception {
        return driverRepository.findAll();
    }


    @Override
    public DriverResponse findNearDrivers(Location location) {
        return null;
    }

    @Override
    public DriverResponse findDriverById(int driverId) {
        try
        {
            Driver getDriver = driverRepository.findById(driverId).get();
            return new DriverResponse(new DriverOutput(getDriver.getId(),getDriver.getPerson().getFirstName(),getDriver.getPerson().getLastName(),getDriver.getLicense()));
        }
        catch (Exception e)
        {
            return new DriverResponse("An error ocurred while getting driver: "+e.getMessage());
        }
    }

    @Override
    public DriverResponse getAllDrivers() {
        try
        {
            List<Driver> drivers = driverRepository.findAll();
            List<DriverOutput> driverOutputList = new ArrayList<>();
            for (Driver d:drivers) {
                driverOutputList.add(new DriverOutput(d.getId(),d.getPerson().getFirstName(),d.getPerson().getLastName(),d.getLicense()));
            }
            return new DriverResponse(driverOutputList);
        }
        catch (Exception e)
        {
            return new DriverResponse("An error ocurred while getting driver list: "+e.getMessage());
        }
    }
}
