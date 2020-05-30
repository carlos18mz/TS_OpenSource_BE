package com.softper.ts.Resources.Comunications;

import com.softper.ts.Resources.Outputs.VehicleOutput;
import java.util.List;
public class VehicleResponse extends BaseResponse<VehicleOutput>{
    public VehicleResponse(List<VehicleOutput> vehicleOutputList) {super(vehicleOutputList);}
    public VehicleResponse(VehicleOutput vehicleOutput) {super(vehicleOutput);}
    public VehicleResponse(String message) {super(message);}
}
