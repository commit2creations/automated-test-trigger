Feature: The calculator is working fine

  Scenario: The calculator can add
    Given that we are on the calculator page
    When I ADD 1 and 1 together
    Then I should see 2 as the result

  Scenario Template: The calculator can <function>
    Given that we are on the calculator page
    When I <function> <first> and <second> together
    Then I should see <answer> as the result
    Examples:
      | function | first | second | answer |
      | ADD      | 1     | 2      | 3      |
      | SUBTRACT | 1     | 2      | -1     |
      | MULTIPLY | 2     | 2      | 4      |
      | DIVIDE   | 2     | 2      | 1      |

  