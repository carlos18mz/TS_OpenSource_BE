package com.softper.ts.Services;

import com.softper.ts.Model.Vehicle;
import com.softper.ts.Resources.Comunications.VehicleResponse;
import com.softper.ts.Resources.Outputs.VehicleOutput;
import com.softper.ts.Resources.Inputs.VehicleInput;

import java.util.List;

public interface IVehicleService extends ICrudService<Vehicle> {
    VehicleResponse findVehiclesByDriverId(int driverId);
    VehicleResponse addVehicleByUserId(int driverId, VehicleInput vehicleInput);
    VehicleResponse findAllVehicles();
    VehicleResponse findVehicleById(int vehicleId);
}
