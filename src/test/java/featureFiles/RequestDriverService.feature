Feature: The customer is looking for a carrier and can request a service indicating
  if he needs it at that time, or for a particular date.

  Scenario: The customer requests a cargo service
    Given that the customer is in the profile window of the selected carrier
    When select the option Request cargo service
    Then the message You requested a cargo service, wait for the confirmation from the driver is displayed

  Scenario: The customer does not request a cargo service
    Given that the client is in the profile window of the selected carrier
    When select the Back option
    Then the profile window of the selected carrier is closed and the search window with results is displayed