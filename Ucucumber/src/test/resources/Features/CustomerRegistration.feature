Feature: Customer Registration

Scenario Outline: Customer registration with valid information
    Given The customer provided url "<url>"
    When customer enter an first "<firstname>" and the "<lastname>"
    And customet enter an "<email>"
    And select gender a "<gender>"
    And customer enter mobile an"<mobile>"
    And select DOB the "<dob>"
    And enter subject the "<subject>"
    And user selects hobby a"<hobby>"
    And Select filepath "<filepath>"
    And Enter current address "<address>"
    And Select current state "<state>"
    And Select current city "<city>"
    And click on the submit button

    Examples:
      | url                                              | firstname | lastname | email         | gender | mobile     | dob         | subject | hobby  | filepath                                          | address            | state | city  |
      | https://demoqa.com/automation-practice-form      | Sumeet    | Gaikwad  | test@test.com | Male   | 9999999999 | 23 Dec 2025 | Maths   | Sports | C:\Users\SUMEET GAIKWAD\eclipse-workspace\practiceproject\data\image (6).png  | Pune, Maharashtra  | NCR   | Delhi |