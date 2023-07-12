Feature: Test login functionality
  I want to use this template for my feature file

  Background: 
    Given I open chrome browser
    When I visit the qa environment
    Then I should be on the login page

  Scenario: verify the fields are present in the application object
    And I enter "batch08@codegator.us.basic" username
    And I enter "Welcome2" password
    When I click the login button
    Then I should see the home page
    And I search for "Applications" object
    And I click the "Applications" object
    And I click the "New" button
    And I enter the "First_Name__c" field as "John"
    And I enter the "Middle_Name__c" field as "W"
    And I enter the "Last_Name__c" field as "Wick"
    And I click the "Marital Status" dropdown field
    And I should see the following option
      | Single  |
      | Married |
      | Other   |


  Scenario: verify loan will be used for field is present
    And I enter "batch08@codegator.us.basic" username
    And I enter "Welcome2" password
    When I click the login button
    Then I should see the home page
    And I search for "Applications" object
    And I click the "Applications" object
    And I click the "New" button
    And I click the "Loan will be used for" dropdown field
    And I should see the following option
      | Business Launch                 |
      | Home Improvement / House Buying |
      | Other                           |
      | Education                       |
      | Investment                      |
    And I select "Business Launch" from the options
    And I click the "Loan will be used for" dropdown field
    And I select "Investment" from the options
    And I scroll down to the "Address" field
    And I click the "Address" dropdown field
    And I select "Canada"
  
  Scenario: verify loan amount field
    And I enter "batch08@codegator.us.basic" username
    And I enter "Welcome2" password
    When I click the login button
    Then I should see the home page
    And I search for "Applications" object
    And I click the "Applications" object
    And I click the "New" button
   And I enter the "Loan_Amount__c" field as "40000"
   
   Scenario: verify phone number field
    And I enter "batch08@codegator.us.basic" username
    And I enter "Welcome2" password
    When I click the login button
    Then I should see the home page
    And I search for "Applications" object
    And I click the "Applications" object
    And I click the "New" button
   	And I enter the "Phone__c" field as "7031234567"
   	
   	 Scenario: verify email field
    And I enter "batch08@codegator.us.basic" username
    And I enter "Welcome2" password
    When I click the login button
    Then I should see the home page
    And I search for "Applications" object
    And I click the "Applications" object
    And I click the "New" button
   	And I enter the "Email__c" field as "defaultemail@gmail.com"
    
     
  Scenario: verify annual income field
    And I enter "batch08@codegator.us.basic" username
    And I enter "Welcome2" password
    When I click the login button
    Then I should see the home page
    And I search for "Applications" object
    And I click the "Applications" object
    And I click the "New" button
      And I enter the "Annual_Income__c" field as "400000"
   
   Scenario: verify phone number field
    And I enter "batch08@codegator.us.basic" username
    And I enter "Welcome2" password
    When I click the login button
    Then I should see the home page
    And I search for "Applications" object
    And I click the "Applications" object
    And I click the "New" button
      And I enter the "Phone__c" field as "4033333333"
      
      Scenario: verify email field
    And I enter "batch08@codegator.us.basic" username
    And I enter "Welcome2" password
    When I click the login button
    Then I should see the home page
    And I search for "Applications" object
    And I click the "Applications" object
    And I click the "New" button
      And I enter the "Email__c" field as "4033333333"
      
        @accounts
      Scenario: verify email field
    And I enter "batch08@codegator.us.basic" username
    And I enter "Welcome2" password
    When I click the login button
    Then I should see the home page
    And I search for "Applications" object
    And I click the "Applications" object
    And I click the "New" button
     And I click the "country" dropdown field and enter "Canada"
     And I select "Canada" from the options 
     And I click the "street" Tab and enter "404 2SW"
   And I click the "city" dropdown field and enter "Calgary"
   And I click the "province" dropdown field and enter "Alberta"
      And I select "Alberta" from the options 
      And I click the "postalCode" dropdown field and enter "TTT343"
   

