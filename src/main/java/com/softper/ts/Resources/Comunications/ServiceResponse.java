package com.softper.ts.Resources.Comunications;
import com.softper.ts.Resources.Outputs.ServiceOutput;

import java.util.List;
public class ServiceResponse extends BaseResponse<ServiceOutput>{
    public ServiceResponse(List<ServiceOutput> serviceOutputList) {super(serviceOutputList);}
    public ServiceResponse(ServiceOutput serviceOutput) {super(serviceOutput);}
    public ServiceResponse(String message) {super(message);}
}
