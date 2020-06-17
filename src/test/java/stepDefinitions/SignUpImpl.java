package stepDefinitions;

import com.softper.ts.Resources.Comunications.UserResponse;
import com.softper.ts.Resources.Inputs.SignUp;
import com.softper.ts.ServicesImp.AuthService;
import com.softper.ts.ServicesImp.UserService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpImpl {

    SignUp signUp;

    private AuthService authService = new AuthService();

    private UserService userService = new UserService();


    @Given("the user is in the register window")
    public void the_user_is_in_the_register_window() {
        signUp = new SignUp();
    }


    @When("you enter your credentials correctly")
    public void you_enter_your_credentials_correctly() {
        // Write code here that turns the phrase above into concrete actions
        signUp = new SignUp("Jhon", "Doe", "customer1@gmail.com", "password", "922345189", 2);
    }

    @Then("you are registered in the application")
    public void you_are_registered_in_the_application() {

        authService.RegisterComplete(signUp);

        UserResponse getUser = userService.findByEmail("customer1@gmail.com");

        if(getUser.success)
            System.out.println("SignUp1 test failed");
        else
            System.out.println("SignUp1 test success");

    }


    @When("you not enter your credentials correctly")
    public void you_not_enter_your_credentials_correctly() {
        signUp = new SignUp("Jhon", "Doe", "", "password", "", 2);

    }

    @Then("you are not registered in the application")
    public void you_are_not_registered_in_the_application() {
        // Write code here that turns the phrase above into concrete actions
        authService.RegisterComplete(signUp);

        UserResponse getUser = userService.findByEmail("customer1@gmail.com");

        if(!getUser.success)
            System.out.println("SignUp2 test failed");
        else
            System.out.println("SignUp2 test success");

    }


}
