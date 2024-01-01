Feature: Login functionality
@smoke
Scenario: valid login
Given user should be on login page
When user enters valid credentials and click on login button
Then user should be navigate to home page
And user can see logout link on home page


Scenario: invalid login
Given user should be on login page
When user enters invalid credentials and click on login button
Then user can see the error message on login page
