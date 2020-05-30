package com.softper.ts.Resources.Comunications;
import com.softper.ts.Resources.Outputs.CargoOutput;

import java.util.List;
public class CargoResponse extends BaseResponse<CargoOutput>{
    public CargoResponse(List<CargoOutput> cargoOutputList) {super(cargoOutputList);}
    public CargoResponse(CargoOutput cargoOutput) {super(cargoOutput);}
    public CargoResponse(String message) { super(message);}
}
