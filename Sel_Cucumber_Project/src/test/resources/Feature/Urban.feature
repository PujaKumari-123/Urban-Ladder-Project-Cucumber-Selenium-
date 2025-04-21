
@tag
Feature: Validate the Urban ladder Website Automation


  @tagnew1
  Scenario: Verifying the working functionality of Urban ladder
    
    Given Open the Browser Enter the Url
    
    And Verify that homepage loaded succesfully
    
    When User Search for a product and click on Search button 
    
    And Verify that Results are displayed
    
    And User apply Filter on Product Search
    
    And Verifies that Results are diplayed as per Filter Applied
    
    Then User Add a product to cart
    
    And User Verify that product added to cart
    
    And User go to Cart
    
    And User click on Checkout button
    
    And Enter details if visible
    
    And User verify that product redirected to the payment page
    