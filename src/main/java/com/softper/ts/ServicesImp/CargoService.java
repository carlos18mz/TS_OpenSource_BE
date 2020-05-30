package com.softper.ts.ServicesImp;

import com.softper.ts.Model.*;
import com.softper.ts.Repositories.*;
import com.softper.ts.Resources.Comunications.AuthResponse;
import com.softper.ts.Resources.Comunications.CargoResponse;
import com.softper.ts.Resources.Inputs.CargoInput;
import com.softper.ts.Resources.Outputs.CargoOutput;
import com.softper.ts.Services.ICargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CargoService implements ICargoService {

    @Override
    public CargoResponse findCargoesByCustomerId(int customerId) {
        return null;
    }

    @Override
    public CargoResponse addCargoByCustomerId(int customerId, CargoInput cargoInput) {
        return null;
    }

    @Override
    public CargoResponse findCargoById(int cargoId) {
        return null;
    }

    @Override
    public CargoResponse findAllCargoes() {
        return null;
    }

    @Override
    public Cargo save(Cargo cargo) throws Exception {
        return null;
    }

    @Override
    public void deleteById(Integer id) throws Exception {

    }

    @Override
    public Optional<Cargo> findById(Integer id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Cargo> findAll() throws Exception {
        return null;
    }
}
