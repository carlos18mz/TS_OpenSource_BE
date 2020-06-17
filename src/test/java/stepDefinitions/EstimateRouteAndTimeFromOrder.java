package stepDefinitions;

import com.softper.ts.Resources.Comunications.CargoResponse;
import com.softper.ts.Resources.Comunications.DriverResponse;
import com.softper.ts.Resources.Comunications.RouteResponse;
import com.softper.ts.Resources.Outputs.RouteOutput;
import com.softper.ts.ServicesImp.CargoService;
import com.softper.ts.ServicesImp.DriverService;
import com.softper.ts.ServicesImp.RouteService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EstimateRouteAndTimeFromOrder {

    DriverResponse driver;
    CargoResponse cargo;
    RouteResponse route;
    DriverService driverService = new DriverService();
    CargoService cargoService = new CargoService();
    RouteService routeService = new RouteService();

    @Given("that the driver is in the details window of the selected cargo service")
    public void that_the_driver_is_in_the_details_window_of_the_selected_cargo_service() {
        driver = driverService.findDriverById(1);
        cargo = cargoService.findCargoById(2);
    }

    @When("you have the GPS activated and select the option See estimated route")
    public void you_have_the_GPS_activated_and_select_the_option_See_estimated_route() {
        route = routeService.findRouteById(1);
        routeService.getRouteInfo(2);
        RouteOutput routeOutput = route.getResource();

    }

    @Then("a map opens showing the estimated route of the order address")
    public void a_map_opens_showing_the_estimated_route_of_the_order_address() {
        RouteResponse response = new RouteResponse("Deploying maps");
        System.out.println(response.getMessage());
        System.out.println("Sent the info o location to frontend and display the location with Google Maps API");
    }

    @When("you have the GPS deactivated and select the option See estimated route")
    public void you_have_the_GPS_deactivated_and_select_the_option_See_estimated_route() {
        System.out.println("Driver GPS its desactivated, so the feature cannot be initialized");
    }

    @Then("the message Activate GPS to continue is displayed")
    public void the_message_Activate_GPS_to_continue_is_displayed() {
        RouteResponse response = new RouteResponse("Activate your GPS to check your current locatión");
        System.out.println(response.getMessage());
        System.out.println("A message is returned 'Activate your GPS to check your current locatión'");
    }
}
