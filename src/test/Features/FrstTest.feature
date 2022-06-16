Feature: Class

  Scenario: Login
    Given I go to this url "https://habibmaternitycenter.momscradle.com/admin/login"
    When I Login using user name "habib@in-school.net" and password "12345678"

  Scenario: Class type CRUD
    Given I go to class type
    When I add class type
    Then I edit class type
    Then I remove class type