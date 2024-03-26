Feature: Serenity Rest QE 14
  @Latihan
  Scenario Outline: Get list users with valid parameter page
    Given Get list user with parameter page <page>
    When Send request get list users
    Then Status code should be 200
    And Response body page should be <page>
    And Validate json schema "ListUsersJsonSchema.json"
    Examples:
      | page |
      | 1    |
      | 2    |

  @Latihan
  Scenario: Post create user with valid json
    Given Create user with valid json "CreateUser.json"
    When Send request create new user
    Then Status code should be 201
    And Response body name should be "Syafiq Ali Zhafran" and job is "QA Engineer"
    And Validate json schema "CreateUserJsonSchema.json"

  @Latihan
  Scenario Outline: Put update user with valid json and user id
    Given Update user with valid json "<json>" and user id <id>
    When Send request put update user
    Then Status code should be 200
    And Response body name should be "<name>" and job is "<job>"
    Examples:
      | id | json             | name                        | job                  |
      | 1  | UpdateUser1.json | Syafiq Ali Zhafran Update 1 | QA Engineer Update 1 |
      | 2  | UpdateUser2.json | Syafiq Ali Zhafran Update 2 | QA Engineer Update 2 |
      | 3  | UpdateUser3.json | Syafiq Ali Zhafran Update 3 | QA Engineer Update 3 |

  @Latihan
  Scenario: Delete user with valid user id
     Given Delete user with user id 2
     When Send request delete user
     Then Status code should be 204