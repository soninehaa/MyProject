Feature: Search from google

  @smoke
  Scenario Outline: search from google
    Given  User open "<searchEngine>" search engine
    When   User enters "<searchTerm>" in search text box
    Then   Verify first search result on the page is "<expectedString>"

Examples:
  | searchTerm          | expectedString  | searchEngine           |
  | Top School in delhi | EducationWorld  | https://www.google.com |
  | Top School in delhi | EducationWorldq | https://www.google.com |