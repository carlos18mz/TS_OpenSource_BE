package com.softper.ts.Resources.Inputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInput {
    public String FirstName;
    public String LastName;
    public String Email;
    public String Password;
    public String Phone;
    public int Discriminator;

    public UserInput(String firstName, String lastName, String email, String password, String phone, int discriminator) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
        Phone = phone;
        Discriminator = discriminator;
    }
}
