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

    @Autowired
    private AuthService authService;


    @GetMapping(value = "/sign-in")
    public ResponseEntity<AuthResponse> SignIn(@Valid @RequestBody SignIn signIn) throws Exception {
        if(signIn == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        AuthResponse result = authService.Login(signIn.getEmail(), signIn.getPassword());

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping(value = "/sign-up")
    public ResponseEntity<AuthResponse> SignUp(@Valid @RequestBody SignUp signUp) throws Exception {

        if(signUp == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        AuthResponse result = authService.RegisterComplete(signUp);

        if(!result.success)
            return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
