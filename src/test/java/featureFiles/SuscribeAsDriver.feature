Feature: Subscribe as a driver

  Scenario: The driver suscribe correctly
    Given the driver is in the subscription window
    When enter all the registration data and select the “Subscribe” option
    Then the driver suscribe to the service

  Scenario: The driver does not subscribe correctly
    Given the driver is in the subscription window
    When select the Suscribe option and the registration data is incomplete
    Then the driver does not subscribe to the service