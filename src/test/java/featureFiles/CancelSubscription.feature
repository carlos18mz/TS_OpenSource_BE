Feature: The driver cancels the subscription that allows you to perform services, if it seems convenient
  Scenario: The driver cancels the subscription
    Given that the driver is in the confirmation window
    When you select the Confirm option
    Then the driver's subscription is canceled and the message Subscription canceled is displayed

  Scenario: The driver does not cancel the subscription
    Given that the driver is in the confirmation window
    When the user selects the Back option
    Then the driver's subscription is not canceled and the confirmation window closes