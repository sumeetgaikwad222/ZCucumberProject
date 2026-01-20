Feature: Select valid checkbox

  @Sumeet
  Scenario Outline: Select correct checkbox
    Given user opens browser
    When user opens the website "<url>"
    And user selects checkbox "<option>"

    Examples:
      | url                                | option |
      | https://www.letskodeit.com/practice | BMW    |
      | https://www.letskodeit.com/practice | Honda  |
