package com.softper.ts.Converters;

import com.softper.ts.Resources.Outputs.VehicleOutput;
import com.softper.ts.Model.Vehicle;

public class VehicleConverter implements IConverter<Vehicle, VehicleOutput> {
    @Override
    public Vehicle fromResouce(VehicleOutput resource) {
        Vehicle newVehicle = new Vehicle();
        newVehicle.setLoadingCapacity(resource.getLoadingCapacity());
        newVehicle.setBrand(resource.getBrand());
        newVehicle.setModel(resource.getModel());
        return newVehicle;
    }

    @Override
    public VehicleOutput fromEntity(Vehicle entity) {
        //return new VehicleResponse(entity.getModel(),entity.getBrand(),entity.getLoadingCapacity());
        return null;
    }
}
