Feature: LoginV1
  Scenario: Login with valid username and password
    Given user is on login page
    And user input username with "ADTP604T"
    And user input password with "andika12345"
    When user click on login button
    Then user is on home page

  Scenario: Login with invalid username and password
    Given user is on login page
    And user input username with "adhitya"
    And user input password with "1234"
    When user click on login button
    Then user is on login page

  Scenario: Login with invalid username
    Given user is on login page
    And user input username with "adhitya"
    And user input password with "andika12345"
    When user click on login button
    Then user is on login page

  Scenario: Login with invalid password
    Given user is on login page
    And user input username with "ADTP604T"
    And user input password with "12345"
    When user click on login button
    Then user is on login page