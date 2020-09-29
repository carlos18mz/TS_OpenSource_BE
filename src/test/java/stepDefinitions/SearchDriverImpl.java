package stepDefinitions;

import com.softper.ts.Resources.Comunications.CustomerResponse;
import com.softper.ts.Resources.Comunications.DriverResponse;
import com.softper.ts.ServicesImp.CustomerService;
import com.softper.ts.ServicesImp.DriverService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchDriverImpl {
    DriverResponse driver;
    CustomerResponse customer;
    DriverService driverService = new DriverService();
    CustomerService customerService  = new CustomerService();

    @Given("that the customer is in the search window")
    public void that_the_customer_is_in_the_search_window() {
        customer = customerService.findCustomerById(1);
    }


    @When("enter search information and select the Search option")
    public void enter_search_information_and_select_the_Search_option() {
        driver = driverService.findDriverById(2);
    }

    @Then("drivers are displayed according to search criteria")
    public void drivers_are_displayed_according_to_search_criteria() {
        if(driver != null)
            System.out.println("SearchDriver scenario1 test success");
        else
            System.out.println("SearchDriver scenario1 test failed");
    }

    @When("enter search information and there are no driver according to the search criteria")
    public void enter_search_information_and_there_are_no_driver_according_to_the_search_criteria() {
        // Write code here that turns the phrase above into concrete actions
        driver = driverService.findDriverById(99);
    }

    @Then("no driver found")
    public void no_driver_found() {
        if(driver == null)
            System.out.println("SearchDriver scenario2 test success");
        else
            System.out.println("SearchDriver scenario2 test failed");
    }

}
