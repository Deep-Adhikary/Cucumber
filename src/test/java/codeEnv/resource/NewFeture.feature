Feature: Testing Cucumber
  Background:
    Given Steps needs to be perform before scenario
    Scenario: Verify User can use umbrella
      Given It is raining and user is outside
      When User un tie Knot
      And Press on open Switch
      Then Umbrella should open
      But The clothes of umbrella should not be torn

  Scenario: Verify User can use KC Paul umbrella
    Given It is raining and user is outside
    When User un tie Knot
    And Press on open Switch
    Then Umbrella should open
    But The clothes of umbrella should not be torn