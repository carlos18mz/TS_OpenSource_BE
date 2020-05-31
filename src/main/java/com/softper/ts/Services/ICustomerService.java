package com.softper.ts.Services;

import com.softper.ts.Model.Customer;
import com.softper.ts.Resources.Comunications.CustomerResponse;
import com.softper.ts.Resources.Outputs.CustomerOutput;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ICustomerService extends ICrudService<Customer>{
    CustomerResponse findCustomerById(int customerId);
    CustomerResponse getAllCustomers();
}
