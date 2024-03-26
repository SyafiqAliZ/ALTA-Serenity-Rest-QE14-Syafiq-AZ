Feature: Login User

  #Positive Test case
  @Tugas
  Scenario:Post user login with valid json
    Given Login user with valid json "LoginUser.json"
    When Send request post login user
    Then Status code should be 200
    And Validate json schema "LoginUserJsonSchema.json"

  #Negative Test Case
  @Tugas
  Scenario Outline: Post user login with invalid json
    Given Login user with invalid json "<json>"
    When Send request post login user
    Then Status code should be 400
    And Validate json schema "LoginUserInvalidJsonSchema.json"
    Examples:
      | json                   |
      | LoginUserInvalid1.json |
      | LoginUserInvalid2.json |
      | LoginUserInvalid3.json |
