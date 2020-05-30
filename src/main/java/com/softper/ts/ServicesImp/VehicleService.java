package com.softper.ts.ServicesImp;

import com.softper.ts.Model.Driver;
import com.softper.ts.Model.Soat;
import com.softper.ts.Repositories.IDriverRepository;
import com.softper.ts.Repositories.ISoatRepository;
import com.softper.ts.Resources.Comunications.FavouriteResponse;
import com.softper.ts.Resources.Comunications.VehicleResponse;
import com.softper.ts.Resources.Outputs.VehicleOutput;
import com.softper.ts.Resources.Inputs.VehicleInput;
import com.softper.ts.Services.IVehicleService;
import com.softper.ts.Model.Vehicle;
import com.softper.ts.Repositories.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements IVehicleService {

    @Override
    public VehicleResponse findVehiclesByDriverId(int driverId) {
        return null;
    }

    @Override
    public VehicleResponse addVehicleByUserId(int driverId, VehicleInput vehicleInput) {
        return null;
    }

    @Override
    public VehicleResponse findAllVehicles() {
        return null;
    }

    @Override
    public VehicleResponse findVehicleById(int vehicleId) {
        return null;
    }

    @Override
    public Vehicle save(Vehicle vehicle) throws Exception {
        return null;
    }

    @Override
    public void deleteById(Integer id) throws Exception {

    }

    @Override
    public Optional<Vehicle> findById(Integer id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Vehicle> findAll() throws Exception {
        return null;
    }
}
