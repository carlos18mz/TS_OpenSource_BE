package com.softper.ts.Services;

import com.softper.ts.Model.Service;
import com.softper.ts.Resources.Comunications.ServiceResponse;
import com.softper.ts.Resources.Outputs.ServiceOutput;
import java.util.List;

public interface IServiceService extends ICrudService<Service> {
    ServiceResponse findServicesByDriverId(int driverId);
    ServiceResponse findAllServices();
    ServiceResponse createService(int driverId);
}
