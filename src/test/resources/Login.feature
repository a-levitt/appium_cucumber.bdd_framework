Feature: Login scenarios

  Scenario Outline: Login with username and password one of which is invalid
    Given User should be on login page
    When Enter username as "<username>"
    And Enter password as "<password>"
    And Press login button
    Then Login fails with error <err>

    Examples:
      | username      | password        | err                                                          |
      | invalidUser   | secret_sauce    | Username and password do not match any user in this service. |
      | standard_user | invalidPassword | Username and password do not match any user in this service. |

  Scenario Outline: Login with valid username and password
    Given User should be on login page
    When Enter username as "<username>"
    And Enter password as "<password>"
    And Press login button
    Then Products Page opens with title "<title>"

    Examples:
      | username      | password        | title    |
      | standard_user | secret_sauce    | PRODUCTS |