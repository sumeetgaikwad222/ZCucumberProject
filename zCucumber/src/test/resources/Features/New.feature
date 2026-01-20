Feature: Login functionality

@smoke
  Scenario Outline: Successful login
    Given user lauch a chrome browser
    When  user opens url "https://www.letskodeit.com/practice"
    Then user selects radio button "Honda"
    
Examples:
|radio|
|Honda|