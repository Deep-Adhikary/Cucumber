Feature: Login To Facebook
  Background:
    Given User is in Facebook Login Page
  Scenario: User can login with proper credential
    When User enter username as "adhikary33@gmail.com" and password for User
    And Click on Login Button
    Then Login should be successful