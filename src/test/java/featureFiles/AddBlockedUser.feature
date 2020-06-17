Feature: The user can select some other user for blocked

  Scenario: The user adds the user to "Blockeds"
    Given that the user is in the profile window of the selected other user
    When you select the “Block user” option
    Then the user is added to the User's blocked list and the message “User blocked” is displayed

  Scenario: The client does not add the user to "Blockeds"
    Given that the user is in the profile window of the selected other user
    When you don't select the “Block user” option
    Then the user is not added to the user's blockeds list