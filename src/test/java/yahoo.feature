Feature: Login Action 
   Description: This feature will test a LogIn , compose mail and Logout functionality

Scenario: Yahoo mail Login
Given User is home page of yahoo
When User navigate to login page
Then User enter Username and click on next button
And User enter password
And  Click on Next button of password
Then User is login sucessfully 

Scenario: Compose mail
Given User is login sucessfully 
When User is click on compose button
Then User enter valid email address
And User enter subject
And User enter body
Then click on send button

Scenario: Signout Yahoo mail
Given User is login sucessfully 
When User click on user account name for signout
Then User click on signout 
Then User close the browser

