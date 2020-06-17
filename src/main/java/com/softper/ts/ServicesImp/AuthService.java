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
        return null;
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
