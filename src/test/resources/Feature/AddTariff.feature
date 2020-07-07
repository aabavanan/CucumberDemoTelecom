#Add Tariff Plan
Feature: Add the Tariff Pan in Demo Guru

  Scenario: Demo Guru99 site Add Tariff customer Plan - Hardcoded
    Given User launches telecom web application
    And Click on the Add Tariff Plan
    When Close the Video Pop up window
    And Enter the Tariff Plan Data value
    And Click on the Tariff submit button
    Then Check the congratulations message
    And Close Tariff browser

  Scenario: Demo Guru99 - One Dimension
    Given User launches telecom web application
    And Click on the Add Tariff Plan
    When Close the Video Pop up window
    And Enter the Tariff Plan Data value in 1dimesion list
      | 599 | 2000 | 2000 | 200 | 2 | 20 | 4 |
    And Click on the Tariff submit button
    Then Check the congratulations message
    And Close Tariff browser
