@rerun
Feature: Rerunning failed scenarios
  @smoke
  Scenario: one
    Given User adds two numbers
    Then Result should be as expected
  @smoke
  Scenario: two
    Given User adds three numbers
    Then Result should be sum of three numbers
  @smoke
  Scenario: three
    Given User divides two numbers
    Then Result should be division result
  @smoke
  Scenario: four
    Given User multiplies two numbers
    Then Result should be multiplication result
