package com.softper.ts.Services;

import com.softper.ts.Resources.Comunications.CargoResponse;
import com.softper.ts.Resources.Inputs.CargoInput;
import com.softper.ts.Model.Cargo;
import com.softper.ts.Resources.Outputs.CargoOutput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICargoService extends ICrudService<Cargo>{
    CargoResponse findCargoesByCustomerId(int customerId);
    CargoResponse addCargoByCustomerId(int customerId, CargoInput cargoInput);
    CargoResponse findCargoById(int cargoId);
    CargoResponse findAllCargoes();
    CargoResponse setCargoDelivered(int cargoId);
}
