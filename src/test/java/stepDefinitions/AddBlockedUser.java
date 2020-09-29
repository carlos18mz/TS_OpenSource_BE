package stepDefinitions;

import com.softper.ts.Resources.Comunications.BlockedResponse;
import com.softper.ts.Resources.Comunications.UserResponse;
import com.softper.ts.ServicesImp.UserService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddBlockedUser {
    UserResponse user;
    UserResponse blocked;
    UserService userService = new UserService();
    BlockedResponse blockedResponse = new BlockedResponse();

    @Given("that the user is in the profile window of the selected other user")
    public void that_the_user_is_in_the_profile_window_of_the_selected_other_user() {
        user = userService.findUserById(1);
        blocked = userService.findUserById(3);
        userService.setFavourited(1,3);
    }

    @When("you select the “Block user” option")
    public void you_select_the_Block_user_option() {
        blockedResponse = userService.findBlockByUserIdAndBlockedId(1,3);
    }

    @Then("the user is added to the User's blocked list and the message “User blocked” is displayed")
    public void the_user_is_added_to_the_User_s_blocked_list_and_the_message_User_blocked_is_displayed() {

        if(blockedResponse.success)
            System.out.println("AddBlockedUser scenario1 test success");
        else
            System.out.println("AddBlockedUser scenario1 test failed");
    }

    @When("you don't select the “Block user” option")
    public void you_don_t_select_the_Block_user_option() {
        System.out.println("Int the frontend dont select block user");
    }

    @Then("the user is not added to the user's blockeds list")
    public void the_user_is_not_added_to_the_user_s_blockeds_list() {
        if(!blockedResponse.success)
            System.out.println("AddBlockedUser scenario2 test success");
        else
            System.out.println("AddBlockedUser scenario2 test failed");
    }
}
