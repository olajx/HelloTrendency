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
      | origo                  |
      | planet                 |
      | zoldut                 |
      | act2manage             |
      | parlament              |
      | hackerAgency           |
      | ovb                    |

  Scenario: Filter by react
    When I filter by "React"
    Then I should see the following references:
      | viragosMo                           |
      | siarena                             |
      | magyarTurUgy                        |
      | magyarFejlBank                      |
      | TheTVoice                           |

  Scenario: Filter by testing
    When I filter by "Teszteles"
    Then I should see the following references:
      | dssCons                              |
