#Author: your.email@your.domain.com
Feature: Add Customer in DemoGur99
  Using for creation new account

  Scenario: Demo Guru99 site Add new customer
    Given User launches telecom web application in Chrome
    And Click on the Add Customer
    When Close the Pop up window
    And Enter the customer fields
    And Click on submit button
    Then Check the Customer ID is displayed
    And Close the Browser