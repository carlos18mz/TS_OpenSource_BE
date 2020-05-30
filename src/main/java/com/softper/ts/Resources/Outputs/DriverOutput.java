package com.softper.ts.Resources.Outputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DriverOutput {
    private int id;
    private String FirstName;
    private String LastName;
    private String License;

    public DriverOutput(int id, String firstName, String lastName, String license) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        License = license;
    }
}
