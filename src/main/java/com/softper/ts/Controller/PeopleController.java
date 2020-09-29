package com.softper.ts.Controller;

import com.softper.ts.Resources.Comunications.PersonResponse;
import com.softper.ts.Resources.Outputs.PersonOutput;
import com.softper.ts.ServicesImp.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/People")
public class PeopleController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<PersonResponse> findAllPersons()
    {
        PersonResponse result = personService.findAllPersons();

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("{personId}")
    public ResponseEntity<PersonResponse> findPersonById(@PathVariable(value = "personId")int personId)
    {
        PersonResponse result = personService.findPeopleById(personId);
        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
