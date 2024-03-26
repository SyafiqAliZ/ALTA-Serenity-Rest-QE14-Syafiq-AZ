package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import static org.hamcrest.Matchers.equalTo;

public class SingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;
    ReqresResponses reqresResponses;

//Scenario 1
    @Given("Get user with valid id {int}")
    public void getUserWithValidId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request get user")
    public void sendRequestGetUser() {
        SerenityRest.when()
                .get(ReqresAPI.SINGLE_USER);
    }

    @And("Response body name should be {int} and {string}")
    public void responseBodyNameShouldBeAnd(int id, String email) {
        SerenityRest.and()
                .body(reqresResponses.DATA_ID,equalTo(id))
                .body(reqresResponses.DATA_EMAIL,equalTo(email));
    }

//Scenario 2
    @Given("Get user with invalid id {string}")
    public void getUserWithInvalidId(String id) {
        reqresAPI.getSingleUserInvalid(id);
    }
}
