package com.softper.ts.ServicesImp;
import com.softper.ts.Model.Person;
import com.softper.ts.Repositories.IPersonRepository;
import com.softper.ts.Resources.Comunications.CustomerResponse;
import com.softper.ts.Resources.Outputs.CustomerOutput;
import com.softper.ts.Services.ICustomerService;
import com.softper.ts.Model.Customer;
import com.softper.ts.Repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository customerRepository;

    @Autowired
    IPersonRepository personRepository;

    @Override
    public Customer save(Customer customer) throws Exception {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> findById(Integer id) throws Exception {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAll() throws Exception {
        return customerRepository.findAll();
    }

    @Override
    public CustomerResponse findCustomerById(int customerId) {
        try
        {
            Customer getCustomer = customerRepository.findById(customerId).get();
            return new CustomerResponse(new CustomerOutput(getCustomer.getId(),getCustomer.getPerson().getFirstName(),getCustomer.getPerson().getLastName(),getCustomer.getCredits()));
        }
        catch (Exception e)
        {
            return new CustomerResponse("An error ocurred while getting customer: "+e.getMessage());
        }

    }

    @Override
    public CustomerResponse getAllCustomers() {
        try
        {
            List<Customer> customerList = customerRepository.findAll();
            List<CustomerOutput> customerOutputList = new ArrayList<>();
            for (Customer c:customerList) {
                Person getPerson = personRepository.findById(c.getId()).get();
                customerOutputList.add(new CustomerOutput(c.getId(),getPerson.getFirstName(),getPerson.getLastName(),c.getCredits()));
            }
            return new CustomerResponse(customerOutputList);
        }
        catch (Exception e)
        {
            return new CustomerResponse("An error ocurred while getting customer list: "+e.getMessage());
        }

    }

}