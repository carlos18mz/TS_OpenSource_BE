package com.softper.ts.Resources.Outputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserOutput {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String role;

    public UserOutput(String email, String password, String firstName, String lastName, String role) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
}
