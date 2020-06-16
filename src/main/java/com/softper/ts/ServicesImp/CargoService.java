package com.softper.ts.ServicesImp;

import com.softper.ts.Model.*;
import com.softper.ts.Repositories.*;
import com.softper.ts.Resources.Comunications.AuthResponse;
import com.softper.ts.Resources.Comunications.CargoResponse;
import com.softper.ts.Resources.Inputs.CargoInput;
import com.softper.ts.Resources.Outputs.CargoOutput;
import com.softper.ts.Services.ICargoService;
import com.softper.ts.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CargoService implements ICargoService {

    @Autowired
    private ICargoRepository cargoRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private IPriceRepository priceRepository;
    @Autowired
    private IBalanceRepository balanceRepository;
    @Autowired
    private IServiceRepository serviceRepository;
    @Autowired
    private ILocationRepository locationRepository;

    @Override
    public Cargo save(Cargo cargo) throws Exception {
        return cargoRepository.save(cargo);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        cargoRepository.deleteById(id);
    }

    @Override
    public Optional<Cargo> findById(Integer id) throws Exception {
        return cargoRepository.findById(id);
    }

    @Override
    public List<Cargo> findAll() throws Exception {
        return cargoRepository.findAll();
    }


    @Override
    public CargoResponse findCargoesByCustomerId(int customerId) {
        try
        {
            List<Cargo> cargoes = cargoRepository.findCargoesByCustomerId(customerId);
            List<CargoOutput> cargoOutputList = new ArrayList<>();
            for (Cargo c:cargoes) {
                CargoOutput newCargoOutput = new CargoOutput();

                newCargoOutput.setWeight(c.getWeight());
                newCargoOutput.setCustomer(c.getCustomer().getPerson().getFirstName()+" "+c.getCustomer().getPerson().getFirstName());
                newCargoOutput.setDriver(c.getService().getServicesRequest().getDriver().getPerson().getFirstName()+" "+c.getService().getServicesRequest().getDriver().getPerson().getLastName());
                newCargoOutput.setStartTime(c.getService().getStartTime());
                newCargoOutput.setFinishTime(c.getService().getFinishTime());
                newCargoOutput.setServicePrice(c.getPrice().getTotalPrice());
                newCargoOutput.setDescription(c.getDescription());
                newCargoOutput.setCargoType(c.getCargoType().toString());
                newCargoOutput.setCargoStatus(c.getCargoStatus());
                cargoOutputList.add(newCargoOutput);
            }
            return new CargoResponse(cargoOutputList);
        }
        catch (Exception e)
        {
            return new CargoResponse("An error ocurred while getting cargo list: "+e.getMessage());
        }
    }

    @Override
    public CargoResponse addCargoByCustomerId(int customerId, CargoInput cargoInput) {

        try
        {
            com.softper.ts.Model.Service getService = serviceRepository.findById(cargoInput.getServiceId()).get();
            Customer getCustomer = customerRepository.findById(customerId).get();
            if(getCustomer.getCredits() - cargoInput.getServicePrice()<0)
                return new CargoResponse("You dont have enough credits");
            Price newPrice = new Price();
            newPrice.setTotalPrice((double) cargoInput.getServicePrice());
            newPrice.setTax(((double) cargoInput.getServicePrice()) * 0.19);
            newPrice.setPriceType(2);
            newPrice = priceRepository.save(newPrice);

            Cargo newCargo = new Cargo();
            newCargo.setCustomer(getCustomer);
            newCargo.setService(getService);
            newCargo.setDescription(cargoInput.getDescription());
            newCargo.setWeight(cargoInput.getWeight());
            newCargo.setPrice(newPrice);
            newCargo.setCargoType("Chemicals");
            newCargo.setCargoStatus("Awaiting");
            newCargo = cargoRepository.save(newCargo);

            Location newLocation = new Location();
            newLocation.setArrivalAltitude(1.0);
            newLocation.setArrivalLatitude(2.0);
            newLocation.setArrivalLongitude(3.0);
            newLocation.setDepartureAltitude(4.0);
            newLocation.setDepartureLatitude(5.0);
            newLocation.setDepartureLongitude(6.0);
            newLocation.setRoute(getService.getRoute());
            newLocation.setCargo(newCargo);
            newLocation = locationRepository.save(newLocation);

            CargoOutput newCargoOutput = new CargoOutput();

            newCargoOutput.setWeight(newCargo.getWeight());
            newCargoOutput.setCustomer(newCargo.getCustomer().getPerson().getFirstName()+" "+newCargo.getCustomer().getPerson().getFirstName());
            newCargoOutput.setDriver(newCargo.getService().getServicesRequest().getDriver().getPerson().getFirstName()+" "+newCargo.getService().getServicesRequest().getDriver().getPerson().getLastName());
            newCargoOutput.setStartTime(newCargo.getService().getStartTime());
            newCargoOutput.setFinishTime(newCargo.getService().getFinishTime());
            newCargoOutput.setServicePrice(newCargo.getPrice().getTotalPrice());
            newCargoOutput.setDescription(newCargo.getDescription());
            newCargoOutput.setCargoType(newCargo.getCargoType());
            newCargoOutput.setCargoStatus(newCargo.getCargoStatus());

            return new CargoResponse(newCargoOutput);
        }
        catch (Exception e)
        {
            return new CargoResponse("An error ocurred while registering a cargo: "+e.getMessage());
        }

    }

    @Override
    public CargoResponse findCargoById(int cargoId) {
        try
        {
            Cargo getCargo = cargoRepository.findById(cargoId).get();

            CargoOutput newCargoOutput = new CargoOutput();

            newCargoOutput.setWeight(getCargo.getWeight());
            newCargoOutput.setCustomer(getCargo.getCustomer().getPerson().getFirstName()+" "+getCargo.getCustomer().getPerson().getFirstName());
            newCargoOutput.setDriver(getCargo.getService().getServicesRequest().getDriver().getPerson().getFirstName()+" "+getCargo.getService().getServicesRequest().getDriver().getPerson().getLastName());
            newCargoOutput.setStartTime(getCargo.getService().getStartTime());
            newCargoOutput.setFinishTime(getCargo.getService().getFinishTime());
            newCargoOutput.setServicePrice(getCargo.getPrice().getTotalPrice());
            newCargoOutput.setDescription(getCargo.getDescription());
            newCargoOutput.setCargoType(getCargo.getCargoType().toString());
            newCargoOutput.setCargoStatus(getCargo.getCargoStatus());

            return new CargoResponse(newCargoOutput);
        }
        catch (Exception e)
        {
            return new CargoResponse("An error ocurred while getting a cargo: "+e.getMessage());
        }


    }

    @Override
    public CargoResponse findAllCargoes() {
        try
        {
            List<Cargo> cargoes = cargoRepository.findAll();
            List<CargoOutput> cargoOutputList = new ArrayList<>();
            for (Cargo c:cargoes) {
                CargoOutput newCargoOutput = new CargoOutput();
                newCargoOutput.setWeight(c.getWeight());
                newCargoOutput.setCustomer(c.getCustomer().getPerson().getFirstName()+" "+c.getCustomer().getPerson().getFirstName());
                newCargoOutput.setDriver(c.getService().getServicesRequest().getDriver().getPerson().getFirstName()+" "+c.getService().getServicesRequest().getDriver().getPerson().getLastName());
                newCargoOutput.setStartTime(c.getService().getStartTime());
                newCargoOutput.setFinishTime(c.getService().getFinishTime());
                newCargoOutput.setServicePrice(c.getPrice().getTotalPrice());
                newCargoOutput.setDescription(c.getDescription());
                newCargoOutput.setCargoType(c.getCargoType().toString());
                newCargoOutput.setCargoStatus(c.getCargoStatus());
                cargoOutputList.add(newCargoOutput);
            }
            return new CargoResponse(cargoOutputList);
        }
        catch (Exception e)
        {
            return new CargoResponse("An error ocurred while getting the cargo list: "+e.getMessage());
        }
    }

    @Override
    public CargoResponse setCargoDelivered(int cargoId) {
        try
        {
            Cargo getCargo = cargoRepository.findById(cargoId).get();
            User getUser = userRepository.findUserByPersonId(getCargo.getCustomer().getPerson().getId())
                    .orElseThrow(()->new ResourceNotFoundException("user","id",cargoId));
            Customer getCustomer = getCargo.getCustomer();
            Balance getBalance = getUser.getBalance();

            getBalance.setSpentMoney(getBalance.getSpentMoney() + getCargo.getPrice().getTotalPrice());
            getCustomer.setCredits(getCustomer.getCredits() - getCargo.getPrice().getTotalPrice());
            getCargo.setCargoStatus("Received");

            getBalance = balanceRepository.save(getBalance);
            getCustomer = customerRepository.save(getCustomer);
            getCargo = cargoRepository.save(getCargo);

            CargoOutput newCargoOutput = new CargoOutput();

            newCargoOutput.setWeight(getCargo.getWeight());
            newCargoOutput.setCustomer(getCargo.getCustomer().getPerson().getFirstName()+" "+getCargo.getCustomer().getPerson().getFirstName());
            newCargoOutput.setDriver(getCargo.getService().getServicesRequest().getDriver().getPerson().getFirstName()+" "+getCargo.getService().getServicesRequest().getDriver().getPerson().getLastName());
            newCargoOutput.setStartTime(getCargo.getService().getStartTime());
            newCargoOutput.setFinishTime(getCargo.getService().getFinishTime());
            newCargoOutput.setServicePrice(getCargo.getPrice().getTotalPrice());
            newCargoOutput.setDescription(getCargo.getDescription());
            newCargoOutput.setCargoType(getCargo.getCargoType().toString());
            newCargoOutput.setCargoStatus(getCargo.getCargoStatus());

            return new CargoResponse(newCargoOutput);
        }
        catch (Exception e)
        {
            return new CargoResponse("An error ocurred while getting the cargo list: "+e.getMessage());
        }
    }
}
