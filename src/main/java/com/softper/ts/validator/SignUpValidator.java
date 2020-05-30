package com.softper.ts.validator;
import com.softper.ts.Resources.Inputs.SignUp;
import com.softper.ts.Services.IUserService;
import com.softper.ts.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;

@Component
public class SignUpValidator implements Validator{

    @Autowired
    private IUserService userService;

    @Override
    public boolean supports(Class<?> aClass) { return User.class.equals(aClass); }

    @Override
    public void validate(Object o, Errors errors) {
        SignUp signUp = (SignUp) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", "NotEmpty");
        if(signUp.getEmail().length() < 6 || signUp.getEmail().length() > 32){
            errors.rejectValue("email","Size.userForm.email");
        }

        /*
        try{
            if(userService.findByEmail(signUp.getEmail()).isPresent()) {
                errors.rejectValue("email", "Duplicate.userForm.email");
            }
        } catch (Exception e){
            e.printStackTrace();;
        }efq

         */

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","NotEmpty");
        if (signUp.getPassword().length() < 8 || signUp.getPassword().length() > 32){
            errors.rejectValue("password","Size.userForm.password");
        }

    }
}
