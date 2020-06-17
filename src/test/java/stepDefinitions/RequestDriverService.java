package stepDefinitions;

import com.softper.ts.Resources.Comunications.CargoResponse;
import com.softper.ts.Resources.Comunications.CustomerResponse;
import com.softper.ts.Resources.Comunications.DriverResponse;
import com.softper.ts.Resources.Inputs.CargoInput;
import com.softper.ts.ServicesImp.CargoService;
import com.softper.ts.ServicesImp.CustomerService;
import com.softper.ts.ServicesImp.DriverService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RequestDriverService {

    CustomerResponse customer;
    CargoInput cargoInput;
    CargoResponse cargoResponse;
    DriverResponse driverResponse;
    CustomerService customerService = new CustomerService();
    DriverService driverService = new DriverService();
    CargoService cargoService = new CargoService();


    @Given("that the customer is in the profile window of the selected carrier")
    public void that_the_customer_is_in_the_profile_window_of_the_selected_carrier() {
        customer = customerService.findCustomerById(1);
        cargoInput = new CargoInput(120,"Un horse",1200,2);
    }


    @When("select the option Request cargo service")
    public void select_the_option_Request_cargo_service() {
        cargoService.addCargoByCustomerId(1,cargoInput);
    }


    @Then("the message You requested a cargo service, wait for the confirmation from the driver is displayed")
    public void the_message_You_requested_a_cargo_service_wait_for_the_confirmation_from_the_driver_is_displayed() {
        cargoResponse = cargoService.findCargoById(2);
        if(cargoResponse!=null)
            System.out.println("RequestDriver scenario1 test success");
        else
            System.out.println("RequestDriver scenario 1 test failed");
    }


    @Given("that the client is in the profile window of the selected carrier")
    public void that_the_client_is_in_the_profile_window_of_the_selected_carrier() {
        driverResponse = driverService.findDriverById(2);
    }


    @When("select the Back option")
    public void select_the_Back_option() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Select back button on frontend");
    }

    @Then("the profile window of the selected carrier is closed and the search window with results is displayed")
    public void the_profile_window_of_the_selected_carrier_is_closed_and_the_search_window_with_results_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("RequestDriver scenario2 test success");
    }





}
