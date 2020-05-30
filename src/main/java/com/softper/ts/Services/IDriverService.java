package com.softper.ts.Services;

import com.softper.ts.Model.Driver;
import com.softper.ts.Model.Location;
import com.softper.ts.Resources.Comunications.DriverResponse;
import com.softper.ts.Resources.Outputs.DriverOutput;

import java.util.List;

public interface IDriverService extends ICrudService<Driver> {
    DriverResponse findNearDrivers(Location location);

    DriverResponse findDriverById(int driverId);
    DriverResponse getAllDrivers();
}
