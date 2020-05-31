package com.softper.ts.Controller;

import com.softper.ts.Repositories.ICustomerRepository;
import java.util.List;

import com.softper.ts.Resources.Comunications.CustomerResponse;
import com.softper.ts.Resources.Outputs.CustomerOutput;
import com.softper.ts.ServicesImp.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<CustomerResponse> findAllCustomers()
    {
        CustomerResponse result = customerService.getAllCustomers();

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{cargoId}")
    public ResponseEntity<CustomerResponse> findCustomersById(@PathVariable(value = "cargoId") int cargoId)
    {
        CustomerResponse result = customerService.findCustomerById(cargoId);

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
