@ui @healthcheck
@tag



Feature: Automation practice
  
  
   @tag1
  Scenario: User is able to open the browser, verify the title and search for product t-shirts
    Given User Opend the Browser
    And User redirected to the application url
    When User Search for product "t-shirts"
    Then Search Result page is displayed