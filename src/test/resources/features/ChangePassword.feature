@ChangePassword

Feature: Change Profile Password

Scenario: user should be able to change the profile password when given valid details

	  Given Open Chrome and start application
    When I enter valid username "Pradyumnan" and password "KYCnet123"
    Then User should be able to login successfully
    When User clicks on the settings button "KYCnet123,Pradyumnan1,Kubendran1,Pradyumnan.Kubendran@kyc.com"
    Then User navigates to the change profile password page "Pradyumnan1" , "Kubendran1" , "KYCnet123"
    And close the browser