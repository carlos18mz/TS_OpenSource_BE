package stepDefinitions;

import com.softper.ts.Resources.Comunications.CargoResponse;
import com.softper.ts.Resources.Comunications.DriverResponse;
import com.softper.ts.ServicesImp.CargoService;
import com.softper.ts.ServicesImp.DriverService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConfirmCargoService {

    DriverResponse driver;
    CargoResponse cargo;
    DriverService driverService = new DriverService();
    CargoService cargoService = new CargoService();

    @Given("that the driver is in the location when needs to transport some cargo")
    public void that_the_driver_is_in_the_location_when_needs_to_transport_some_cargo() {
        driver = driverService.findDriverById(3);
    }

    @When("you select the Confirm service option")
    public void you_select_the_Confirm_service_option() {
        System.out.println("In the frontend select Confirms action in the cargo profile");
        cargoService.setCargoDelivered(2);
    }

    @Then("a notification is sent to the customer with the message {string}")
    public void a_notification_is_sent_to_the_customer_with_the_message(String string) {
        cargo = cargoService.findCargoById(5);
        System.out.println("A notification will vbe sent to the customer asociated");
    }

    @Given("that the driver is not in the location when needs to transport some cargo")
    public void that_the_driver_is_not_in_the_location_when_needs_to_transport_some_cargo() {
        System.out.println("In the frontend select Confirms action in the cargo profile");
    }

    @When("you you select the Confirm service option")
    public void you_you_select_the_Confirm_service_option() {
        cargoService.setCargoDelivered(2);
    }

    @Then("the application shows a message Indicating that you have not yet arrived")
    public void the_application_shows_a_message_Indicating_that_you_have_not_yet_arrived() {
        cargo = cargoService.findCargoById(5);
        System.out.println("You have not yet arrived");
    }

}
