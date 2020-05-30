package com.softper.ts.ServicesImp;

import com.softper.ts.Model.*;
import com.softper.ts.Repositories.*;
import com.softper.ts.Resources.Comunications.AuthResponse;
import com.softper.ts.Resources.Outputs.AuthenticatedOutput;
import com.softper.ts.Resources.Inputs.SignUp;
import com.softper.ts.Services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class AuthService implements IAuthService {

    @Override
    public AuthResponse RegisterComplete(SignUp signUp) {
        return null;
    }

    @Override
    public AuthResponse Login(String email, String password) {
        return null;
    }
}
