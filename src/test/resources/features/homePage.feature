@HomePage
Feature: Home Page test
  @HomePage @smoke @regression @HomePageTest
  Scenario: Verify Account List Button
    Given User opens Home home page
    When Verify Page Title
    And User navigate to Account List Button
    And Open Your Orders Page
    Then Verifies order page title