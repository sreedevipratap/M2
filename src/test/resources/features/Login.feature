
@Login

Feature: Login authentication
  
 
Scenario Outline: Test Login with Valid credentials
    Given User is on application Home Page
    When User enters valid username "<username>" and password "<password>"
    Then User should be able to login successfully
    And close the browser
    

Examples: 
      | username              | password  |
      | Bakkiya | KYCnet123 |
     
     	
Scenario Outline: Test Login with Invalid credentials
    Given User is on application Home Page
    When User enters valid username "<username>" and password "<password>"
    #Given The user is on the application login page
    Then User should not be able to login successfully
    And close the browser

Examples: 
      | username              | password  |
      #| javier van der meulen | KYCnet123 |
     	| abc  | abc123 |