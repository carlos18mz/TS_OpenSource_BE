package com.softper.ts.Resources.Comunications;
import com.softper.ts.Resources.Outputs.DriverOutput;

import java.util.List;
public class DriverResponse extends BaseResponse<DriverOutput> {
    public DriverResponse(List<DriverOutput> driverOutputList) {super(driverOutputList);}
    public DriverResponse(DriverOutput driverOutput) {super(driverOutput);}
    public DriverResponse(String message) {super(message);}
}
