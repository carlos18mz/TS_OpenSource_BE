package stepDefinitions;

import com.softper.ts.Resources.Comunications.DriverResponse;
import com.softper.ts.Resources.Comunications.SubscriptionResponse;
import com.softper.ts.ServicesImp.DriverService;
import com.softper.ts.ServicesImp.SubscriptionService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SuscribeAsDriverImpl {

    DriverResponse driver;
    DriverService driverService = new DriverService();
    SubscriptionService subscriptionService = new SubscriptionService();


    @Given("the driver is in the subscription window")
    public void the_driver_is_in_the_subscription_window() {
        driver = driverService.findDriverById(1);
    }

    @When("enter all the registration data and select the “Subscribe” option")
    public void enter_all_the_registration_data_and_select_the_Subscribe_option() {
        subscriptionService.suscribe(1,2);
    }

    @Then("the driver suscribe to the service")
    public void the_driver_suscribe_to_the_service() {
        SubscriptionResponse subscription = subscriptionService.findSubscriptionById(1);
        if(subscription!=null)
            System.out.println("SuscribeAsDriver test success");
        else
            System.out.println("SuscribeAsDriver test failed");
    }



    @When("select the Suscribe option and the registration data is incomplete")
    public void select_the_Suscribe_option_and_the_registration_data_is_incomplete() {
        // Write code here that turns the phrase above into concrete actions
        subscriptionService.suscribe(1,9999);
    }


    @Then("the driver does not subscribe to the service")
    public void the_driver_does_not_subscribe_to_the_service() {

        SubscriptionResponse subscription = subscriptionService.findSubscriptionById(1);
        if(subscription==null)
            System.out.println("SuscribeAsDriver test success");
        else
            System.out.println("SuscribeAsDriver test failed");
    }


}
