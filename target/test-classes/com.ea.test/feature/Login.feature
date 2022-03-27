Feature: Login Feature

  Scenario: login process
    And I see application opened
    Then I click login link
    When I enter UserName and Password
    | UserName|Password|
    | admin   |password|
    Then I click login button
    Then I should see the username with hello