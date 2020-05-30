package com.softper.ts.Resources.Inputs;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SignUp {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phone;

    private int discriminator;

}
