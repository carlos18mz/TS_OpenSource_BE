package com.softper.ts.ServicesImp;
import com.softper.ts.Model.Person;
import com.softper.ts.Repositories.IPersonRepository;
import com.softper.ts.Resources.Comunications.CargoResponse;
import com.softper.ts.Resources.Comunications.CustomerResponse;
import com.softper.ts.Resources.Outputs.CustomerOutput;
import com.softper.ts.Services.ICustomerService;
import com.softper.ts.Model.Customer;
import com.softper.ts.Repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Override
    public CustomerResponse findCustomerById(int customerId) {
        return null;
    }

    @Override
    public CustomerResponse getAllCustomers() {
        return null;
    }

    @Override
    public CustomerResponse getAllPages(Pageable pageable) {
        return null;
    }

    @Override
    public Customer save(Customer customer) throws Exception {
        return null;
    }

    @Override
    public void deleteById(Integer id) throws Exception {

    }

    @Override
    public Optional<Customer> findById(Integer id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Customer> findAll() throws Exception {
        return null;
    }
}