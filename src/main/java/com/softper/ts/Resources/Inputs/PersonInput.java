package com.softper.ts.Resources.Inputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonInput {

    private long id;
    private String firstName;
    private String lastName;

    public PersonInput(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
