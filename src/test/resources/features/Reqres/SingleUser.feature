Feature: Get Single User

  #Positive Test Case
  @Tugas
  Scenario Outline: Get single user with valid id
    Given Get user with valid id <id>
    When Send request get user
    Then Status code should be 200
    And Response body name should be <id> and "<email>"
    And Validate json schema "SingleUserJsonSchema.json"
    Examples:
      | id | email                  |
      | 1  | george.bluth@reqres.in |
      | 2  | janet.weaver@reqres.in |

  #Negative Test Case
  @Tugas
  Scenario Outline: Get single user with invalid id
    Given Get user with invalid id "<id>"
    When Send request get user
    Then Status code should be 404
    Examples:
      | id   |
      | satu |
      | dua  |
      | tiga |
