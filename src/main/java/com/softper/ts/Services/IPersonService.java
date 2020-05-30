package com.softper.ts.Services;

import com.softper.ts.Model.Person;
import com.softper.ts.Resources.Comunications.PersonResponse;
import com.softper.ts.Resources.Comunications.PlanResponse;
import com.softper.ts.Resources.Outputs.PersonOutput;
import java.util.List;

public interface IPersonService extends ICrudService<Person> {

    PersonResponse findPeopleById(int id);

    PersonResponse findAllPersons();
}
