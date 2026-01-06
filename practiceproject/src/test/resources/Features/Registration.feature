Feature: Registration

  Scenario Outline: Customer registration with valid information
    Given The customer opening url "<url>"
    When customer enter first "<firstname>" and "<lastname>"
    And customet enter "<email>"
    And select gender "<gender>"
    And customer enter mobile "<mobile>"
    And select DOB "<dob>"
    And enter subject "<subject>"
    And user selects hobby "<hobby>"
    And Select file "<filepath>"
    And Enter address "<address>"
    And Select state "<state>"
    And Select city "<city>"
    And click on submit button

    Examples:
      | url                                              | firstname | lastname | email         | gender | mobile     | dob         | subject | hobby  | filepath                                          | address            | state | city  |
      | https://demoqa.com/automation-practice-form      | Sumeet    | Gaikwad  | test@test.com | Male   | 9999999999 | 23 Dec 2025 | Maths   | Sports | C:\Users\SUMEET GAIKWAD\eclipse-workspace\practiceproject\data\image (6).png  | Pune, Maharashtra  | NCR   | Delhi |