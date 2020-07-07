#Author: Aabavanan
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

  # -----------------------------------------------------------------
  Scenario: Demo Guru99 site Add new customer - One Dimension list
    Given User launches telecom web application in Chrome
    And Click on the Add Customer
    When Close the Pop up window
    And Enter the customer fields in 1dimensional list
      | Aaba | vanan | aaba@xyz.com | Chennai | 9952131160 |
    And Click on submit button
    Then Check the Customer ID is displayed
    And Close the Browser

  # -----------------------------------------------------------------
  Scenario: Demo Guru99 site Add new customer - One Dimension map
    Given User launches telecom web application in Chrome
    And Click on the Add Customer
    When Close the Pop up window
    And Enter the customer fields in 1dimensional map
      | fname   | karthi      |
      | lname   | rajan       |
      | mail    | xyz@xyz.com |
      | address | chennai     |
      | phone   |  9952131160 |
    And Click on submit button
    Then Check the Customer ID is displayed
    And Close the Browser

  # -----------------------------------------------------------------
  Scenario: Demo Guru99 site Add new customer - Two Dimension list
    Given User launches telecom web application in Chrome
    And Click on the Add Customer
    When Close the Pop up window
    And Enter the customer fields in 2dimensional list
      | Aaba    | vanan | aaba@xyz.com | Chennai | 9952131160 |
      | Brindha | vanan | bin@xyz.com  | Erode   | 9952131160 |
    And Click on submit button
    Then Check the Customer ID is displayed
    And Close the Browser

  # -----------------------------------------------------------------
  Scenario: Demo Guru99 site Add new customer - Two Dimension Map
    Given User launches telecom web application in Chrome
    And Click on the Add Customer
    When Close the Pop up window
    And Enter the customer fields in 2dimensional map
      | fname  | lname    | mail         | address | phone      |
      | Aaba   | vanan    | ab@gmail.com | salem   | 8976436275 |
      | Logu   | soundar  | lg@gmail.com | chenaai | 8976436275 |
      | karthi | rajan    | kr@gmail.com | chennai | 8976436275 |
      | arun   | pandiyan | ap@gmail.com | madurai | 8976436275 |
    And Click on submit button
    Then Check the Customer ID is displayed
    And Close the Browser
