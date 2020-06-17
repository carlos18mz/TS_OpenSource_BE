package stepDefinitions;

import com.softper.ts.Resources.Comunications.DriverResponse;
import com.softper.ts.Resources.Comunications.SubscriptionResponse;
import com.softper.ts.ServicesImp.DriverService;
import com.softper.ts.ServicesImp.SubscriptionService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CancelSubscription {
    DriverResponse driverResponse;
    DriverService driverService = new DriverService();
    SubscriptionResponse subscription;
    SubscriptionService subscriptionService = new SubscriptionService();

    @Given("that the driver is in the confirmation window")
    public void that_the_driver_is_in_the_confirmation_window() {
       driverResponse = driverService.findDriverById(1);
       subscription = subscriptionService.findSubscriptionById(2);
    }

    @When("you select the Confirm option")
    public void you_select_the_Confirm_option() {
        System.out.println("In the frontend driver select confirm option");
        subscriptionService.cancelSubscription(2);
    }

    @Then("the driver's subscription is canceled and the message Subscription canceled is displayed")
    public void the_driver_s_subscription_is_canceled_and_the_message_Subscription_canceled_is_displayed() {
        subscription = subscriptionService.findSubscriptionById(2);
        if(subscription.success)
            System.out.println("CancelSubscription scenario 1 test success");
        else
            System.out.println("CalcelSubscription scenario 1 test failed");
    }

    @When("the user selects the Back option")
    public void the_user_selects_the_Back_option() {
        System.out.println("In the frontend driver select back option");
    }

    @Then("the driver's subscription is not canceled and the confirmation window closes")
    public void the_driver_s_subscription_is_not_canceled_and_the_confirmation_window_closes() {

        SubscriptionResponse response = new SubscriptionResponse("Subscription cancel");
        System.out.println("In the frontend returning to the main menu");
    }

}
