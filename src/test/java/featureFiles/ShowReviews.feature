Feature: Users can see the reviews and ratings of other users
  Scenario: The user views a review of a driver
    Given the user is in a driver profile window
    When you select the View Review option from one of the reviews
    Then the selected review is displayed

  Scenario: No reviews
    Given the user is in a driver profile window
    When you select the Reviews and Ratings option and there are no reviews available
    Then the message “The driver has no reviews” is displayed