package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testImpl {
    @Given("I am on the bing search engine")
    public void i_am_on_the_bing_search_engine() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I am Given");
    }

    @When("I enter a search term")
    public void i_enter_a_search_term() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I am When");
    }

    @Then("relevant results for that search term are displayed")
    public void relevant_results_for_that_search_term_are_displayed() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I am Then");
    }

}
