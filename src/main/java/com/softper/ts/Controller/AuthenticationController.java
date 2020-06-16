package com.softper.ts.Controller;
import com.softper.ts.Resources.Comunications.AuthResponse;
import com.softper.ts.Resources.Inputs.SignIn;
import com.softper.ts.Resources.Inputs.SignUp;
import com.softper.ts.ServicesImp.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

}
