Feature: The driver accepts the request for cargo service requested by a customer.
  Scenario: The driver confirms the request for cargo service.
    Given that the driver is in the location when needs to transport some cargo
    When you select the Confirm service option
    Then a notification is sent to the customer with the message "Your service request was accepted"


  Scenario: The driver rejects the request for cargo service.
    Given that the driver is not in the location when needs to transport some cargo
    When you you select the Confirm service option
    Then the application shows a message Indicating that you have not yet arrived