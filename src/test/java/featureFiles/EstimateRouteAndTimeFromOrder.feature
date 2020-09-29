Feature: The driver displays a map showing the destination route of the order.
  Scenario: The driver visualizes the estimated route using a map
  Given that the driver is in the details window of the selected cargo service
  When you have the GPS activated and select the option See estimated route
  Then a map opens showing the estimated route of the order address

  Scenario: Error displaying estimated route
  Given that the driver is in the details window of the selected cargo service
  When you have the GPS deactivated and select the option See estimated route
  Then the message Activate GPS to continue is displayed
