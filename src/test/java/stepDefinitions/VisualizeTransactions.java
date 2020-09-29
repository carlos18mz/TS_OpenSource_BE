package stepDefinitions;

import com.softper.ts.Resources.Comunications.BalanceResponse;
import com.softper.ts.Resources.Comunications.UserResponse;
import com.softper.ts.ServicesImp.BalanceService;
import com.softper.ts.ServicesImp.UserService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VisualizeTransactions {

    UserResponse user;
    UserService userService = new UserService();
    BalanceResponse balance;
    BalanceService balanceService = new BalanceService();


    @Given("the user is in their profile window")
    public void the_user_is_in_their_profile_window() {
        user = userService.findUserById(2);
    }

    @When("select the option “See transactions”")
    public void select_the_option_See_transactions() {
        balance = balanceService.findBalanceById(2);
    }

    @Then("the money transaction window will open")
    public void the_money_transaction_window_will_open() {
        if(balance.success)
            System.out.println("VisualizeTransactions scenario 1 test success");
        else
            System.out.println("VisualizeTransaction scenario 1 test failed");
    }


    @When("you select the option See transactions but you not have done one yet")
    public void you_select_the_option_See_transactions_but_you_not_have_done_one_yet() {

        balance = balanceService.findBalanceById(2);
        balance = new BalanceResponse("You dont have any transaction");
    }

    @Then("the money transaction window will open with a message saying You have not made any transactions")
    public void the_money_transaction_window_will_open_with_a_message_saying_You_have_not_made_any_transactions() {
        if(balance.success)
            System.out.println("VisualizeTransactions scenario 1 test success");
        else
            System.out.println("VisualizeTransaction scenario 1 test failed");
    }


    @Then("the window error while viewing transactions, loss of connection to the application.")
    public void the_window_error_while_viewing_transactions_loss_of_connection_to_the_application() {
        System.out.println("Frontend lost connection with the user device");
        balance = new BalanceResponse("Conection lost");
    }


    @When("you select the option “see transactions” and you have lost the connection")
    public void you_select_the_option_see_transactions_and_you_have_lost_the_connection() {
        System.out.println("You device lost conection");
    }
}
