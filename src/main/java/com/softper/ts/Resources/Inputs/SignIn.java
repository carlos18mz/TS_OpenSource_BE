package com.softper.ts.Resources.Inputs;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SignIn {
    private String email;

    private String password;

    public SignIn(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
