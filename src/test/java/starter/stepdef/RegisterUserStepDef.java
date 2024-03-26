package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class RegisterUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

//Scenario 1
    @Given("Register user with valid json {string}")
    public void registerUserWithValidJson(String json) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        reqresAPI.postRegisterUser(jsonFile);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when()
                .post(ReqresAPI.REGISTER_USER);
    }

    @Given("Register user with invalid json {string}")
    public void registerUserWithInvalid(String json) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        reqresAPI.postRegisterUser(jsonFile);
    }
}
