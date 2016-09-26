Feature: As a music store customer
  	I want to be able to register myself
  	So that I can login in with my user name and password

  Scenario: Register User
    Given I am on Register User Page
    When I enter my details
    Then I am not registered with my new account
