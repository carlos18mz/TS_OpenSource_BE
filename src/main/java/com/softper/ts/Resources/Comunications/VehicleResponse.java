package com.softper.ts.Resources.Comunications;

import com.softper.ts.Resources.Outputs.VehicleOutput;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class VehicleResponse extends BaseResponse<VehicleOutput>{
    public VehicleResponse(List<VehicleOutput> vehicleOutputList) {super(vehicleOutputList);}
    public VehicleResponse(VehicleOutput vehicleOutput) {super(vehicleOutput);}
    public VehicleResponse(String message) {super(message);}
}
