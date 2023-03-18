# Swag Labs Automation testing project

## About the Project
This project it's a front end framework for the page Swag Labs (https://saucedemo.com).

This is a POM(Page Object Model) hybrid with DDT(Data Driven Testing).
The functionality of the project were tested based on the user requirements.

### Pages used in the POM Framework:
* Login Page
* Home Page / Inventory Page
* Cart Page
* CheckOut Page

<br> Test were created to Validate page functionality.

### Tests
* Login Tests where created to validate different scenarios using valid user and passwords and wrong usernames or wrong password.
We use a base `login` function in order to reuse code and simplify testing.
* Login Data is pulled from the `Excel` file located in `DataFile` folder.
* For the e2e flow we added a Product and then proceed to do all the Check-out process. 

### Tools used
* Java
* IntelliJ IDEA
* Maven
* Selenium

### Scenarios and tests to follow
1. Login
   * Valid credentials
   * Invalid Username
   * Invalid Password(Blank)
   * Invalid Password(wrong password)
2. e2e
   * Complete Checkout  
   * Cancel CheckOut

## CI/CD
Implemented with GitHub actions every time a new Commit is set. 