package stepDefinitions;

import com.softper.ts.Resources.Comunications.FavouriteResponse;
import com.softper.ts.Resources.Comunications.UserResponse;
import com.softper.ts.ServicesImp.UserService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddFavouriteDriver {

    UserResponse user;
    UserResponse favourite;
    UserService userService = new UserService();
    FavouriteResponse favouriteResponse = new FavouriteResponse();

    @When("you select the “Add to Favorites” option")
    public void you_select_the_Add_to_Favorites_option() {
        user = userService.findUserById(1);
        favourite = userService.findUserById(3);
        userService.setFavourited(1,3);
    }

    @Then("the carrier is added to the customer's favorites list and the message “Added to favorites” is displayed")
    public void the_carrier_is_added_to_the_customer_s_favorites_list_and_the_message_Added_to_favorites_is_displayed() {
        favouriteResponse = userService.findFavouriteByUserIdAndFavouriteId(1,3);
        if(favouriteResponse.success)
            System.out.println("AddFavouriteDriver scenario1 test success");
        else
            System.out.println("AddFavouriteDriver scenario1 test failed");
    }

    @When("you don't select the “Add to Favorites” option")
    public void you_don_t_select_the_Add_to_Favorites_option() {
        System.out.println("In frontend not select favourites option");
    }

    @Then("the carrier is not added to the customer's favorites list,")
    public void the_carrier_is_not_added_to_the_customer_s_favorites_list() {
        favouriteResponse = userService.findFavouriteByUserIdAndFavouriteId(1,3);
        if(favouriteResponse.success)
            System.out.println("AddFavouriteDriver scenario1 test success");
        else
            System.out.println("AddFavouriteDriver scenario1 test failed");
    }
}
