
Feature: Login funtionality

Scenario: Login with valid user
	Given I am on login page
	When I enter user name an password
	And I click on login button
	Then I verify user login successfully
	