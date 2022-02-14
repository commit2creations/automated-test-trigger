Feature: The calculator is working fine

  Scenario: The calculator can add
    Given that we are on the calculator page
    When I "add" 1 and 1 together
    Then I should see 2 as the result
