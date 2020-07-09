Feature: Tech Demo

  Scenario Outline: Verify personalised greetings
    Given I go to my personalised greeting App
    When I enter name <user name>
    Then I click on greetings button

    Examples:

    |user name|
    |Bob      |