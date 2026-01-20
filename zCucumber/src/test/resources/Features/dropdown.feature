Feature: Select the correct dropdown option


@Sumeet
Scenario Outline: Select options
  Given user opens url of website "<url>"
  When user selects a correct dropdown "<option>"

Examples:
  | url                                | option |
  | https://www.letskodeit.com/practice |Honda  |
