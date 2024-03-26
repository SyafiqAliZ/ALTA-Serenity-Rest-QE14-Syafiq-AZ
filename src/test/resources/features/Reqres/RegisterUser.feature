Feature: Register User

  #Positive Test Case
  @Tugas
  Scenario: Post user register with valid json
    Given Register user with valid json "RegisterUser.json"
    When Send request post register user
    Then Status code should be 200
    And Validate json schema "RegisterUserJsonSchema.json"

  #Negative Test Case
  @Tugas
  Scenario Outline: Post user register with invalid json
    Given Register user with invalid json "<json>"
    When Send request post register user
    Then Status code should be 400
    And Validate json schema "RegisterUserInvalidJsonSchema.json"
    Examples:
      | json                      |
      | RegisterUserInvalid1.json |
      | RegisterUserInvalid2.json |
      | RegisterUserInvalid3.json |