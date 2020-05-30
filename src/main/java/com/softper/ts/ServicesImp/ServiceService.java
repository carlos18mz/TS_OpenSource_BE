package com.softper.ts.ServicesImp;

import com.softper.ts.Model.Driver;
import com.softper.ts.Model.Route;
import com.softper.ts.Model.ServiceRequest;
import com.softper.ts.Repositories.IDriverRepository;
import com.softper.ts.Repositories.IRouteRepository;
import com.softper.ts.Repositories.IServiceRepository;
import com.softper.ts.Repositories.IServiceRequestRepository;
import com.softper.ts.Resources.Comunications.ReviewResponse;
import com.softper.ts.Resources.Comunications.ServiceResponse;
import com.softper.ts.Resources.Outputs.ServiceOutput;
import com.softper.ts.Services.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceService implements IServiceService {

    @Override
    public ServiceResponse findServicesByDriverId(int driverId) {
        return null;
    }

    @Override
    public ServiceResponse findAllServices() {
        return null;
    }

    @Override
    public ServiceResponse createService(int driverId) {
        return null;
    }

    @Override
    public com.softper.ts.Model.Service save(com.softper.ts.Model.Service service) throws Exception {
        return null;
    }

    @Override
    public void deleteById(Integer id) throws Exception {

    }

    @Override
    public Optional<com.softper.ts.Model.Service> findById(Integer id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<com.softper.ts.Model.Service> findAll() throws Exception {
        return null;
    }
}
