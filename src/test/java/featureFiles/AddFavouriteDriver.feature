Feature: The customer can select their favorite driver
  to take them into account for their next orders

  Scenario: The user adds the carrier to "Favorites"
    Given that the client is in the profile window of the selected carrier
    When you select the “Add to Favorites” option
    Then the carrier is added to the customer's favorites list and the message “Added to favorites” is displayed

  Scenario: The client does not add the carrier to "Favorites"
    Given that the client is in the profile window of the selected carrier
    When you don't select the “Add to Favorites” option
    Then the carrier is not added to the customer's favorites list,