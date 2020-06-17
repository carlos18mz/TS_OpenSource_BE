package com.softper.ts.ServicesImp;

import com.softper.ts.Model.*;
import com.softper.ts.Repositories.*;
import com.softper.ts.Resources.Comunications.AuthResponse;
import com.softper.ts.Resources.Outputs.AuthenticatedOutput;
import com.softper.ts.Resources.Inputs.SignUp;
import com.softper.ts.Services.IAuthService;
import com.softper.ts.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private IPersonRepository personRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IDriverRepository driverRepository;

    @Autowired
    private IQualificationRepository qualificationRepository;

    @Autowired
    private IServiceRequestRepository serviceRequestRepository;

    @Autowired
    private IConfigurationRepository configurationRepository;

    @Autowired
    private IBalanceRepository balanceRepository;


    @Override
    public AuthResponse RegisterComplete(SignUp signUp) {
        try
        {
            Person newPerson = new Person();
            newPerson.setFirstName(signUp.getFirstName());
            newPerson.setLastName(signUp.getLastName());
            newPerson.setPhone(signUp.getPhone());
            newPerson.setPersonType(signUp.getDiscriminator());
            newPerson = personRepository.save(newPerson);

            Configuration newConfiguration = new Configuration();
            newConfiguration.setLanguage("Spanish");
            newConfiguration.setPaymentCurrency("Soles");

            newConfiguration = configurationRepository.save(newConfiguration);

            Balance newBalance = new Balance();
            newBalance.setSpentMoney(0);
            newBalance.setAddedMoney(0);

            newBalance = balanceRepository.save(newBalance);

            User user = new User();
            user.setEmail(signUp.getEmail());
            user.setPassword(signUp.getPassword());
            user.setCreatedAt(Calendar.getInstance().getTime());
            user.setPerson(newPerson);
            user.setConfiguration(newConfiguration);
            user.setBalance(newBalance);

            user = userRepository.save(user);

            if(signUp.getDiscriminator() == 1) {
                Customer newCustomer = new Customer();
                newCustomer.setCredits(0.0);
                newCustomer.setPerson(newPerson);
                newPerson.setCustomer(newCustomer);

                customerRepository.save(newCustomer);
            }
            else
            {
                Driver newDriver = new Driver();
                newDriver.setLicense("000-123");
                newDriver.setPerson(newPerson);
                newPerson.setDriver(newDriver);

                Qualification newQualication = new Qualification();
                newQualication.setDriver(newDriver);

                ServiceRequest newServiceRequest = new ServiceRequest();
                newServiceRequest.setDriver(newDriver);

                qualificationRepository.save(newQualication);
                serviceRequestRepository.save(newServiceRequest);
                driverRepository.save(newDriver);
            }
            return new AuthResponse(new AuthenticatedOutput(user.getId(),user.getEmail(),user.getPassword(),newPerson.getFirstName(),newPerson.getLastName(),newPerson.getPersonType()));
        }
        catch (Exception e)
        {
            return new AuthResponse("An error ocurred while register the user: "+e.getMessage());
        }


    }

    @Override
    public AuthResponse Login(String email, String password) {
        try {
            User getUser = userRepository.findByEmail(email)
                    .orElseThrow(()->new ResourceNotFoundException("user","email",email));
            Person getPerson = getUser.getPerson();
            return new AuthResponse(new AuthenticatedOutput(getUser.getId(), getUser.getEmail(), getUser.getPassword(), getPerson.getFirstName(), getPerson.getLastName(), getPerson.getPersonType()));
        }
        catch (Exception e)
        {
            return new AuthResponse("An error ocurred while getting the user: "+e.getMessage());
        }
    }
}
