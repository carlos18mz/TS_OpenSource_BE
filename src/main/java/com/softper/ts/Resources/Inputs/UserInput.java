package com.softper.ts.Resources.Inputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInput {
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private String Phone;
    private int Discriminator;

    public UserInput(String firstName, String lastName, String email, String password, String phone, int discriminator) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
        Phone = phone;
        Discriminator = discriminator;
    }
}
