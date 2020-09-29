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

    @Autowired
    IPersonRepository personRepository;
    @Autowired
    IUserRepository userRepository;

    @Override
    public Person save(Person person) throws Exception {
        return personRepository.save(person);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        personRepository.deleteById(id);
    }

    @Override
    public Optional<Person> findById(Integer id) throws Exception {
        return personRepository.findById(id);
    }

    @Override
    public List<Person> findAll() throws Exception {
        return personRepository.findAll();
    }


    @Override
    public PersonResponse findPeopleById(int id) {
        try
        {
            User getUser = userRepository.findUserByPersonId(id).get();
            Person getPerson = personRepository.findById(id).get();

            PersonOutput newPersonOutput = new PersonOutput();
            newPersonOutput.setEmail(getUser.getEmail());
            newPersonOutput.setFirstName(getPerson.getFirstName());
            newPersonOutput.setLastName(getPerson.getLastName());
            if(getPerson.getPersonType()==1)
                newPersonOutput.setUserType("Customer");
            if(getPerson.getPersonType()==2)
                newPersonOutput.setUserType("Driver");
            return new PersonResponse(newPersonOutput);
        }
        catch (Exception e)
        {
            return new PersonResponse("An error ocurred while getting the person: "+e.getMessage());

        }

    }

    @Override
    public PersonResponse findAllPersons() {
        try
        {
            List<Person> personList = personRepository.findAll();
            List<PersonOutput> personOutputList = new ArrayList<>();
            for (Person p:personList) {
                Optional<User> getUser = userRepository.findUserByPersonId(p.getId());
                PersonOutput newPersonOutput = new PersonOutput();
                newPersonOutput.setEmail(getUser.get().getEmail());
                newPersonOutput.setFirstName(p.getFirstName());
                newPersonOutput.setLastName(p.getLastName());
                if(p.getPersonType()==1)
                    newPersonOutput.setUserType("Customer");
                if(p.getPersonType()==2)
                    newPersonOutput.setUserType("Driver");
                personOutputList.add(newPersonOutput);
            }
            return new PersonResponse(personOutputList);
        }
        catch (Exception e)
        {
            return new PersonResponse("An error ocurred while getting the person list: "+e.getMessage());
        }

    }
}
