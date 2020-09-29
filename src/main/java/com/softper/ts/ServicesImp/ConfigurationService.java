package com.softper.ts.ServicesImp;

import com.softper.ts.Model.Configuration;
import com.softper.ts.Model.PaymentMethod;
import com.softper.ts.Model.User;
import com.softper.ts.Repositories.IConfigurationRepository;
import com.softper.ts.Repositories.IPaymentMethodRepository;
import com.softper.ts.Repositories.IUserRepository;
import com.softper.ts.Resources.Comunications.ConfigurationResponse;
import com.softper.ts.Resources.Inputs.ConfigurationInput;
import com.softper.ts.Resources.Inputs.PaymentMethodInput;
import com.softper.ts.Resources.Outputs.ConfigurationOutput;
import com.softper.ts.Services.IConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConfigurationService implements IConfigurationService {

    @Autowired
    IConfigurationRepository configurationRepository;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IPaymentMethodRepository paymentMethodRepository;

    @Override
    public ConfigurationResponse findAllConfigurations() {
        try
        {
            List<Configuration> configurationList = configurationRepository.findAll();
            List<ConfigurationOutput> configurationOutputList = new ArrayList<>();
            for(Configuration c:configurationList)
            {
                ConfigurationOutput newConfigurationOutput = new ConfigurationOutput();
                newConfigurationOutput.setUserName(c.getUser().getPerson().getFirstName()+" "+c.getUser().getPerson().getLastName());
                newConfigurationOutput.setLanguage(c.getLanguage().toString());
                newConfigurationOutput.setPaymentCurrency(c.getPaymentCurrency().toString());
                configurationOutputList.add(newConfigurationOutput);
            }
            return new ConfigurationResponse(configurationOutputList);
        }
        catch (Exception e)
        {
            return new ConfigurationResponse("An error ocurred while getting a configuration list: "+e.getMessage());
        }
    }

    @Override
    public ConfigurationResponse findConfigurationByUserId(int userId) {
        try
        {
            User getUser = userRepository.findById(userId).get();
            ConfigurationOutput newConfigurationOutput = new ConfigurationOutput();
            newConfigurationOutput.setUserName(getUser.getPerson().getFirstName()+" "+getUser.getPerson().getLastName());
            newConfigurationOutput.setPaymentCurrency(getUser.getConfiguration().getPaymentCurrency().toString());
            newConfigurationOutput.setLanguage(getUser.getConfiguration().getLanguage().toString());
            return new ConfigurationResponse(newConfigurationOutput);
        }
        catch (Exception e)
        {
            return new ConfigurationResponse("An error ocurred while getting a configuration");
        }
    }

    @Override
    public ConfigurationResponse addPaymentMethod(int userId, PaymentMethodInput paymentMethodInput) {
        try
        {
            User getUser = userRepository.findById(userId).get();
            PaymentMethod newPaymentMethod = new PaymentMethod();
            newPaymentMethod.setAccountNumber(paymentMethodInput.getAccountNumber());
            newPaymentMethod.setBankAccountType("");
            newPaymentMethod.setBankName(paymentMethodInput.getBankName());
            newPaymentMethod.setBillingAdress("6666");
            newPaymentMethod.setDni(paymentMethodInput.getDni());
            newPaymentMethod.setFullName(getUser.getPerson().getFirstName()+" "+getUser.getPerson().getLastName());
            newPaymentMethod.setSwiftCode(paymentMethodInput.getSwiftCode());
            newPaymentMethod.setConfiguration(getUser.getConfiguration());

            newPaymentMethod = paymentMethodRepository.save(newPaymentMethod);

            ConfigurationOutput getConfigurationOutput = new ConfigurationOutput();
            getConfigurationOutput.setUserName(getUser.getPerson().getFirstName()+" "+getUser.getPerson().getLastName());
            getConfigurationOutput.setLanguage(getUser.getConfiguration().getLanguage().toString());
            getConfigurationOutput.setPaymentCurrency(getUser.getConfiguration().getPaymentCurrency().toString());
            return new ConfigurationResponse(getConfigurationOutput);
        }
        catch (Exception e)
        {
            return new ConfigurationResponse("An error ocurred while getting a configuration");
        }
    }

    @Override
    public ConfigurationResponse updateConfiguration(int userId, ConfigurationInput configurationInput) {
        try
        {
            User getUser = userRepository.findById(userId).get();
            Configuration getConfiguration = getUser.getConfiguration();
            getConfiguration.setLanguage(configurationInput.getLanguage());
            getConfiguration.setPaymentCurrency(configurationInput.getPaymentCurrency());
            getConfiguration = configurationRepository.save(getConfiguration);

            ConfigurationOutput newConfigurationOutput = new ConfigurationOutput();
            newConfigurationOutput.setPaymentCurrency(getConfiguration.getPaymentCurrency());
            newConfigurationOutput.setLanguage(getConfiguration.getLanguage());
            newConfigurationOutput.setUserName(getUser.getPerson().getFirstName()+" "+getUser.getPerson().getLastName());

            return new ConfigurationResponse(newConfigurationOutput);
        }
        catch (Exception e)
        {
            return new ConfigurationResponse("An error ocurred while getting a configuration");
        }
    }

    @Override
    public Configuration save(Configuration configuration) throws Exception {
        return configurationRepository.save(configuration);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        configurationRepository.deleteById(id);
    }

    @Override
    public Optional<Configuration> findById(Integer id) throws Exception {
        return configurationRepository.findById(id);
    }

    @Override
    public List<Configuration> findAll() throws Exception {
        return configurationRepository.findAll();
    }
}
