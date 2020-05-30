package com.softper.ts.Services;

import com.softper.ts.Resources.Comunications.AuthResponse;
import com.softper.ts.Resources.Inputs.SignUp;

public interface IAuthService {
    AuthResponse RegisterComplete(SignUp signUp);
    AuthResponse Login(String email, String password);
}
