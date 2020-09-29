package stepDefinitions;

import com.softper.ts.Resources.Comunications.DriverResponse;
import com.softper.ts.Resources.Comunications.PaymentMethodResponse;
import com.softper.ts.Resources.Inputs.PaymentMethodInput;
import com.softper.ts.ServicesImp.ConfigurationService;
import com.softper.ts.ServicesImp.DriverService;
import com.softper.ts.ServicesImp.PaymentMethodService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddPaymentMethod {

    DriverResponse driver;
    DriverService driverService = new DriverService();
    ConfigurationService configurationService = new ConfigurationService();
    PaymentMethodService paymentMethodService = new PaymentMethodService();
    PaymentMethodInput paymentMethodInput;
    PaymentMethodResponse paymentMethodResponse;

    @Given("the driver is in the add collection method window")
    public void the_driver_is_in_the_add_collection_method_window() {
        driver = driverService.findDriverById(2);
    }

    @When("you enter the payment method information")
    public void you_enter_the_payment_method_information() {
        paymentMethodInput = new PaymentMethodInput("Interbank", 1068, 523228321, 75261989);
    }

    @When("select the option Add payment method")
    public void select_the_option_Add_payment_method() {
        System.out.println("In the frontend select 'Add payment method'");
        configurationService.addPaymentMethod(2,paymentMethodInput);
    }

    @Then("the new collection method is added and the message Added successfully is displayed")
    public void the_new_collection_method_is_added_and_the_message_Added_successfully_is_displayed() {
        paymentMethodResponse = paymentMethodService.findPaymentMethodByUserId(2);
        if(!paymentMethodResponse.success)
            System.out.println("AddPaymentMethod scenario 1 test success");
        else
            System.out.println("AddPaymentMethod scenario 1 test failed");
    }

    @Given("the carrier is in the add collection method window")
    public void the_carrier_is_in_the_add_collection_method_window() {
        //driver = driverService.findDriverById(2);

    }

    @When("select the Add payment method option")
    public void select_the_Add_payment_method_option() {
        System.out.println("In the frontend select 'Add payment method'");
        configurationService.addPaymentMethod(2,paymentMethodInput);
    }

    @When("the payment method information is empty")
    public void the_payment_method_information_is_empty() {
        paymentMethodInput = new PaymentMethodInput();
    }

    @Then("the collection method is not added and the message Enter collection method information is displayed")
    public void the_collection_method_is_not_added_and_the_message_Enter_collection_method_information_is_displayed() {
        paymentMethodResponse = paymentMethodService.findPaymentMethodByUserId(2);
        if(paymentMethodResponse.success)
            System.out.println("AddPaymentMethod scenario 1 test success");
        else
            System.out.println("AddPaymentMethod scenario 1 test failed");
    }

}
