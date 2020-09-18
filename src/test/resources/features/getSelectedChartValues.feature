Feature: get User selected values

#Scenario: get selected values from tech
#	Given User open tech top stock 
#	When  User gets tech data stock
#	Then  User select top stock 


Scenario: get values from daily chart 
	Given User open top stock 
	When  User open the daily chart 
	Then  User saves the daily chart values in excel
	When  User open the weekly chart
	Then  User saves the weekly chart values in excel
	Then  User Analyses the Data and saves in DB
	