Feature: Adding two numbers in google 
Scenario Outline:: Adding two numbers
	Given user entering calculator
	When user is entered <a> <x> <b>
	And enters the equal to key
	Then the user see the results
Examples:
	| a | x | b |
   	| 5 | + | 6 |
   	| 4 | +	| 3 |
   	| 4 | /	| 2 |