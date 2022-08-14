# encoding: utf-8

Feature: References

  Background:
    Given I navigate to Home page
    And I accept cookies
    Then I should see the "Home" page title

    Given I open the hamburger menu
    When I select the "Reference" menu item
    Then I should see the "References" page title

  Scenario: Filter by android
    When I filter by "Android"
    Then I should see the following references:
      | ORIGO app                                                     |
      | Planet Budapest 2021 Fenntarthatósági Expó és Világtalálkozó  |
      | Zöld út                                                       |
      | Act2manage                                                    |
      | Parlament „E-futár”                                           |
      | Hackeragency                                                  |
      | OVB biztosító                                                 |

  Scenario: Filter by react
    When I filter by "React"
    Then I should see the following references:
      | Virágos Magyarország                |
      | Síaréna                             |
      | Magyar Turisztikai Ügynökség        |
      | Magyar Fejlesztési Bank             |
      | The tenants' voice                  |

  Scenario: Filter by testing
    When I filter by "Tesztelés"
    Then I should see the following references:
      | DSS consulting                      |

  Scenario: Validate other scenarios with negative case (handle NoSuchElementException)
    When I filter by "Tesztelés"
    Then I should see the following references:
      | ORIGO app                           |
