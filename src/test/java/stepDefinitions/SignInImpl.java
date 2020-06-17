package stepDefinitions;

import com.softper.ts.Resources.Comunications.UserResponse;
import com.softper.ts.Resources.Inputs.SignIn;
import com.softper.ts.ServicesImp.AuthService;
import com.softper.ts.ServicesImp.UserService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SignInImpl {

    SignIn signIn;

    private AuthService authService = new AuthService();

    private UserService userService = new UserService();

    @Given("the user is in the login window")
    public void the_user_is_in_the_login_window() {
        signIn = new SignIn();
    }

    @When("you enter your email and password correctly and press login")
    public void you_enter_your_email_and_password_correctly_and_press_login() {
        signIn = new SignIn("customer1@gmail.com","password");
    }


    @Then("you access in the application with your account")
    public void you_access_in_the_application_with_your_account() {

        authService.Login(signIn.getEmail(),signIn.getPassword());

        UserResponse getUser = userService.findByEmail("customer1@gmail.com");

        if(getUser.success)
            System.out.println("SignUp1 test failed");
        else
            System.out.println("SignUp1 test success");

    }



    @When("you not enter your email and password correctly and press login")
    public void you_not_enter_your_email_and_password_correctly_and_press_login() {
        signIn = new SignIn("customer1@gmail.com","pass");
    }



    @Then("you not access in the application")
    public void you_not_access_in_the_application() {
        authService.Login(signIn.getEmail(),signIn.getPassword());

        UserResponse getUser = userService.findByEmail("customer1@gmail.com");

        if(!getUser.success)
            System.out.println("SignUp1 test failed");
        else
            System.out.println("SignUp1 test success");

    }


}
