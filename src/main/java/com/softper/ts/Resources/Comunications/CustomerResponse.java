package com.softper.ts.Resources.Comunications;
import com.softper.ts.Resources.Outputs.CustomerOutput;

import java.util.List;
public class CustomerResponse extends BaseResponse<CustomerOutput>{
    public CustomerResponse(List<CustomerOutput> customerResponseList) {super(customerResponseList);}
    public CustomerResponse(CustomerOutput customerOutput) {super(customerOutput);}
    public CustomerResponse(String message) {super(message);}
}
