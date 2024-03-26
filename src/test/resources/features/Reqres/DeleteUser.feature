Feature: Delete User

  #Positive Test Case
  @Tugas
  Scenario Outline: Delete users with valid user id
    Given Delete users with valid user id <id>
    When Send Request delete user
    Then Status code should be 204
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |

  #Negative Test Case
  @Tugas
  Scenario Outline: Delete users with Invalid user id
    Given Delete users with Invalid user id "<id>"
    When Send Request delete user
    Then Status code should be 404
    Examples:
      | id   |
      | satu |
      | dua  |
      | tiga |