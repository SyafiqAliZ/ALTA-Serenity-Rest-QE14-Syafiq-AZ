package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DeleteUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

//Scenario 1
    @Given("Delete users with valid user id {int}")
    public void deleteUsersWithValidUser(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send Request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when()
                .delete(ReqresAPI.DELETE_USER);
    }

//Scenario 2
    @Given("Delete users with Invalid user id {string}")
    public void deleteUsersWithInvalidUser(String id) {
        reqresAPI.deleteUserInvalid(id);
    }
}
