package com.softper.ts.Converters;

import com.softper.ts.Model.Cargo;

import com.softper.ts.Resources.Outputs.CargoOutput;


public class CargoConverter implements IConverter<Cargo, CargoOutput>  {
    @Override
    public Cargo fromResouce(CargoOutput resource) {
        Cargo cr = new Cargo();
        //cr.setServicePrice(resource.getServicePrice());
        cr.setDescription(resource.getDescription());
        cr.setWeight(resource.getWeight());

        return cr;
    }

    @Override
    public CargoOutput fromEntity(Cargo entity) {
        CargoOutput cr = new CargoOutput();
        //cr.setServicePrice(entity.getServicePrice());
        cr.setDescription(entity.getDescription());
        cr.setWeight(entity.getWeight());
        return cr;
    }
}
