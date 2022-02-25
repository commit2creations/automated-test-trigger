Feature: The calculator is working fine

  Scenario: The calculator can add
    Given that I am on the calculator page
    When I add 1 and 1 together
    Then I should see 2 as the result

  Scenario Template: The calculator can <function>
    Given that I am on the calculator page
    When I <function> <first> and <second> together
    Then I should see <answer> as the result
    Examples:
      | first | function | second | answer |
      | 1     | add      | 2      | 3      |
      | 1     | subtract | 2      | -1     |
      | 2     | multiply | 2      | 4      |
      | 2     | divide   | 2      | 1      |

  Scenario: An incomplete equation shows an exclamation point
    Given that I am on the calculator page
    When I select the numbers 1,2,3
    And I add
    Then I should see the exclamation point near the answer section

  Scenario Outline: I want to get the list of <branch> operations
    Given that I am on the calculator page
    When I select the <branch> menu
    Then I should see <branch>

    Examples:
      | branch       |
      | calculus     |
      | algegra      |
      | statistics   |
      | trigonometry |

  Scenario: Pressing the enter button adds a new row containing the previous equation entered

  Scenario: Clicking on the exclamation point shows a message for reason

  Scenario: Selecting a form on the answer changes the answer format

  Scenario: Selecting a form that the answer can't be converted to shows an exclamation point

  Scenario: Selecting a form on an answer that is saved in the row changes the answer format