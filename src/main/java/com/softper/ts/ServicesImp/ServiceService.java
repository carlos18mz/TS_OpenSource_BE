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

    @Autowired
    private IServiceRequestRepository serviceRequestRepository;

    @Autowired
    private IServiceRepository serviceRepository;

    @Autowired
    private IDriverRepository driverRepository;

    @Autowired
    private IRouteRepository routeRepository;


    @Override
    public ServiceResponse findServicesByDriverId(int driverId) {
        try
        {
            List<com.softper.ts.Model.Service> services = serviceRepository.findServicesByDriverId(driverId);
            List<ServiceOutput> serviceOutputList = new ArrayList<>();
            for (com.softper.ts.Model.Service s:services) {
                ServiceOutput newServiceOutput = new ServiceOutput();
                newServiceOutput.setFirstName(s.getServicesRequest().getDriver().getPerson().getFirstName());
                newServiceOutput.setLastName(s.getServicesRequest().getDriver().getPerson().getLastName());
                newServiceOutput.setStartedTime(s.getStartTime());
                newServiceOutput.setFinishTime(s.getFinishTime());
                newServiceOutput.setServiceState(s.getServiceState());
                serviceOutputList.add(newServiceOutput);
            }
            return new ServiceResponse(serviceOutputList);
        }
        catch (Exception e)
        {
            return new ServiceResponse("An error ocurred while getting the service list : "+e.getMessage());
        }

    }

    @Override
    public ServiceResponse findAllServices() {
        try
        {
            List<com.softper.ts.Model.Service> services = serviceRepository.findAll();
            List<ServiceOutput> serviceOutputList = new ArrayList<>();
            for (com.softper.ts.Model.Service s:services) {
                ServiceOutput newServiceOutput = new ServiceOutput();
                newServiceOutput.setFirstName(s.getServicesRequest().getDriver().getPerson().getFirstName());
                newServiceOutput.setLastName(s.getServicesRequest().getDriver().getPerson().getLastName());
                newServiceOutput.setStartedTime(s.getStartTime());
                newServiceOutput.setFinishTime(s.getFinishTime());
                newServiceOutput.setServiceState(s.getServiceState());
                serviceOutputList.add(newServiceOutput);
            }
            return new ServiceResponse(serviceOutputList);
        }
        catch (Exception e)
        {
            return new ServiceResponse("An error ocurred while getting the service list : "+e.getMessage());

        }

    }

    @Override
    public ServiceResponse createService(int driverId) {
        try
        {
            Driver getDriver = driverRepository.findById(driverId).get();
            ServiceRequest getServiceRequest = serviceRequestRepository.findServiceByDriverId(driverId);

            Route newRoute = new Route();
            newRoute.setDistance(200.0);
            newRoute = routeRepository.save(newRoute);

            com.softper.ts.Model.Service newService = new com.softper.ts.Model.Service();
            newService.setServiceState("OnProcess");
            newService.setServicesRequest(getServiceRequest);
            newService.setRoute(newRoute);
            newService.setStartTime(Calendar.getInstance().getTime());
            newService.setFinishTime(Calendar.getInstance().getTime());

            newService = serviceRepository.save(newService);

            ServiceOutput newServiceOutput = new ServiceOutput();
            newServiceOutput.setFirstName(getDriver.getPerson().getFirstName());
            newServiceOutput.setLastName(getDriver.getPerson().getLastName());
            newServiceOutput.setStartedTime(newService.getStartTime());
            newServiceOutput.setFinishTime(newService.getFinishTime());
            newServiceOutput.setServiceState(newService.getServiceState());

            return new ServiceResponse(newServiceOutput);
        }
        catch (Exception e)
        {
            return new ServiceResponse("An error ocurred while registering the service : "+e.getMessage());
        }

    }

    @Override
    public com.softper.ts.Model.Service save(com.softper.ts.Model.Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public void deleteById(Integer id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Optional<com.softper.ts.Model.Service> findById(Integer id) {
        return serviceRepository.findById(id);
    }

    @Override
    public List<com.softper.ts.Model.Service> findAll() {
        return serviceRepository.findAll();
    }
}
