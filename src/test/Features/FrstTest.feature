Feature: Class

#  Scenario: Login
#    Given I go to this url "https://habibmaternitycenter.momscradle.com/admin/login"
#    When I Login using user name "habib@in-school.net" and password "12345678"
#
#  Scenario: Class type CRUD
#    Given I go to this url "https://habibmaternitycenter.momscradle.com/admin/login"
#    When I Login using user name "habib@in-school.net" and password "12345678"
#    Then I go to class type
#    Then I add class type
#    Then I edit class type
#    Then I remove class type

#  Scenario: Class CRUD
#    Given I go to this url "https://habibmaternitycenter.momscradle.com/admin/login"
#    When I Login using user name "habib@in-school.net" and password "12345678"
#    Then I go to class
#    Then I add class
#    Then I edit class
#    Then I remove class

  Scenario: POS Class
    Given I go to this url "https://habibmaternitycenter.momscradle.com/admin/login"
    When I Login using user name "habib@in-school.net" and password "12345678"
    Then I go to POS
    Then I Select class
    Then I make payment

  Scenario: POS Product
    Given I go to this url "https://habibmaternitycenter.momscradle.com/admin/login"
    When I Login using user name "habib@in-school.net" and password "12345678"
    Then I go to POS
    Then I Select Product
    Then I make payment

  Scenario: POS Rental
    Given I go to this url "https://habibmaternitycenter.momscradle.com/admin/login"
    When I Login using user name "habib@in-school.net" and password "12345678"
    Then I go to POS
    Then I Select Rental
    Then I make payment