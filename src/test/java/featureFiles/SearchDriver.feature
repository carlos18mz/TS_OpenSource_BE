Feature: The customer searches for the available drivers for the cargo service he requires,
  indicating whether he needs it for the moment, or for later.

  Scenario: The customer is looking for a driver successfully
    Given that the customer is in the search window
    When enter search information and select the Search option
    Then drivers are displayed according to search criteria

  Scenario: The customer cannot find a driver
    Given that the customer is in the search window
    When enter search information and there are no driver according to the search criteria
    Then no driver found