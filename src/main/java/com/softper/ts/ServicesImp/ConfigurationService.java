package com.softper.ts.ServicesImp;

import com.softper.ts.Model.Configuration;
import com.softper.ts.Resources.Comunications.ConfigurationResponse;
import com.softper.ts.Resources.Inputs.ConfigurationInput;
import com.softper.ts.Resources.Inputs.PaymentMethodInput;
import com.softper.ts.Services.IConfigurationService;

import java.util.List;
import java.util.Optional;

public class ConfigurationService implements IConfigurationService {
    @Override
    public ConfigurationResponse findAllConfigurations() {
        return null;
    }

    @Override
    public ConfigurationResponse findConfigurationByUserId(int userId) {
        return null;
    }

    @Override
    public ConfigurationResponse addPaymentMethod(int userId, PaymentMethodInput paymentMethodInput) {
        return null;
    }

    @Override
    public ConfigurationResponse updateConfiguration(int userId, ConfigurationInput configurationInput) {
        return null;
    }

    @Override
    public Configuration save(Configuration configuration) throws Exception {
        return null;
    }

    @Override
    public void deleteById(Integer id) throws Exception {

    }

    @Override
    public Optional<Configuration> findById(Integer id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Configuration> findAll() throws Exception {
        return null;
    }
}
