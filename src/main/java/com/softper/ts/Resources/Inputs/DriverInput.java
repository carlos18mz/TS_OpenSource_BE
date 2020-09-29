package com.softper.ts.Resources.Inputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DriverInput {
    private String firstName;
    private String lastName;
    private String License;

    public DriverInput(String firstName, String lastName, String license) {
        this.firstName = firstName;
        this.lastName = lastName;
        License = license;
    }
}
