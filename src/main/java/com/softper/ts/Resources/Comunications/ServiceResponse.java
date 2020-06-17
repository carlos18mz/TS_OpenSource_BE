package com.softper.ts.Resources.Comunications;
import com.softper.ts.Resources.Outputs.ServiceOutput;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ServiceResponse extends BaseResponse<ServiceOutput>{
    public ServiceResponse(List<ServiceOutput> serviceOutputList) {super(serviceOutputList);}
    public ServiceResponse(ServiceOutput serviceOutput) {super(serviceOutput);}
    public ServiceResponse(String message) {super(message);}
}
