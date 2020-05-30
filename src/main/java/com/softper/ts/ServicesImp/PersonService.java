package com.softper.ts.ServicesImp;

import com.softper.ts.Model.User;
import com.softper.ts.Repositories.IUserRepository;
import com.softper.ts.Resources.Comunications.AuthResponse;
import com.softper.ts.Resources.Comunications.PersonResponse;
import com.softper.ts.Resources.Outputs.PersonOutput;
import com.softper.ts.Services.IPersonService;
import com.softper.ts.Model.Person;
import com.softper.ts.Repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IPersonService {

    @Override
    public PersonResponse findPeopleById(int id) {
        return null;
    }

    @Override
    public PersonResponse findAllPersons() {
        return null;
    }

    @Override
    public Person save(Person person) throws Exception {
        return null;
    }

    @Override
    public void deleteById(Integer id) throws Exception {

    }

    @Override
    public Optional<Person> findById(Integer id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Person> findAll() throws Exception {
        return null;
    }
}
