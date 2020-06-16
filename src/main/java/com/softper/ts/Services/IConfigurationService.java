package com.softper.ts.Services;

import com.softper.ts.Model.Configuration;
import com.softper.ts.Resources.Comunications.ConfigurationResponse;
import com.softper.ts.Resources.Inputs.ConfigurationInput;
import com.softper.ts.Resources.Inputs.PaymentMethodInput;

public interface IConfigurationService extends ICrudService<Configuration> {
    ConfigurationResponse findAllConfigurations();
    ConfigurationResponse findConfigurationByUserId(int userId);
    ConfigurationResponse addPaymentMethod(int userId, PaymentMethodInput paymentMethodInput);
    ConfigurationResponse updateConfiguration(int userId, ConfigurationInput configurationInput);

}
