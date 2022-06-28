Feature: Api testing for CRUID operations

  Background:
    Given user given api url enter "https://gorest.co.in/"


  Scenario Outline: Post create a new user

    Given set api endpoint "public/v2/users"
    And user creates new user with request body"<Name>","<Gender>","<Email>","<Status>"
    Then validate in a status code 201
    And validate the userId is not null
    And validate the user name is "<Name>"
    And validate the user Gender is "<Gender>"
    And validate the user Email is "<Email>"
    And validate the user Status is "<Status>"


    Examples:User  Details table

      | Name        | Gender | Email                | Status |
      | Aslan Yusuf | male   | yusufasla112n@boehm.com | active |




