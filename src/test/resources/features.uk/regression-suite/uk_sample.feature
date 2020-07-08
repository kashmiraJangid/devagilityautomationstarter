Feature: UK Sample Regression Suite

  Scenario Outline: Personalised Greeting scenario
    Given I start journey
    When I enter name as <name>
    And I click on Get Greeting button
    Then I must see response

    Examples:
      | name  |
      | Bob   |

