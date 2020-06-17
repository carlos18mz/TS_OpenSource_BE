package com.softper.ts.Resources.Comunications;
import com.softper.ts.Resources.Outputs.PersonOutput;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class PersonResponse extends BaseResponse<PersonOutput>{
    public PersonResponse(List<PersonOutput> personResponseList) {super(personResponseList);}
    public PersonResponse(PersonOutput personOutput) { super(personOutput);}
    public PersonResponse(String message) {super(message);}
}
