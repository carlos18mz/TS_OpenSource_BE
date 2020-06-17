Feature: Drivers add different means of payment such as a credit card,
  manually or by scanning the card code with the cell phone.

  Scenario: The carrier adds a new collection method
    Given the driver is in the add collection method window
    When you enter the payment method information
    And select the option Add payment method
    Then the new collection method is added and the message Added successfully is displayed

  Scenario: Error adding collection method
    Given the carrier is in the add collection method window
    When select the Add payment method option
    And the payment method information is empty
    Then the collection method is not added and the message Enter collection method information is displayed
