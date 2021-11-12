
Feature: Sample exercise

  Scenario: To get the employee details and to create an employee record
    Given start the script
    Then script execution in progress

    Then create the client
    And Hit the url1 with the get request
    And validate and print the response


    And Hit the url2 with the post request
    Then Pass the employee record to be added using post request
    And Execution completed

