Feature: Select correct option

Scenario Outline: select multiple
  Given browser setup and initials
  When user provides baseurl "<baseurl>"
  Then locate and select multiple options "<options>"

Examples:
  | baseurl                              | options              |
  | https://www.letskodeit.com/practice | Apple,Orange,Peach  |
