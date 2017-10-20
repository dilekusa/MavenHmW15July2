Feature: Herokup dynamic 

@HerokupDynamicLoading										
Scenario: Test the dynamic loading 
	Given User Navigate to herokuapp
	When user read the description 
	And user create a List of webelements and add all Links that contain example partialLinktext using findElements 
	And user ensure you are 2 links in the collection 
	When Click on the first link 
	When Click on start button 
	And Wait until Loading bar is invisible 
	And Assert That Hello World is displayed 
	And Go Back to Previous page 
	When Click on the 2nd link 
	And Click on Start Button for 2nd link 
	And Wait until oading secondbar ins
	When Wait until Hello World is visiblein secondlink 
	Then Assert That Hello World is displayed for secomd link
