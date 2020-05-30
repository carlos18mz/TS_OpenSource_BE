package com.softper.ts.Resources.Comunications;
import com.softper.ts.Resources.Outputs.PersonOutput;

import java.util.List;
public class PersonResponse extends BaseResponse<PersonOutput>{
    public PersonResponse(List<PersonOutput> personResponseList) {super(personResponseList);}
    public PersonResponse(PersonOutput personOutput) { super(personOutput);}
    public PersonResponse(String message) {super(message);}
}
