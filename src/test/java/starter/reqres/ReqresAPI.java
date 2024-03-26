package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {

    public static String LIST_USERS = Constants.BASE_URL+"/api/users?page={page}";
    public static String CREATE_USER = Constants.BASE_URL+"/api/users";
    public static String UPDATE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String LOGIN_USER = Constants.BASE_URL+"/api/login";
    public static String REGISTER_USER = Constants.BASE_URL+"/api/register";
    public static String SINGLE_USER = Constants.BASE_URL+"/api/users/{id}";

    @Step("Get list user with valid parameter page")
    public void getListUsers(int page){
        SerenityRest.given()
                .pathParam("page",page);
    }

    @Step("Post create user with valid json")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user with valid json and user id")
    public void putUpdateUser(File json, int id){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user with valid json and invalid user id")
    public void putUpdateUserinvalid(File json, String id) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user with valid user id")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Delete user with Invalid user id")
    public void deleteUserInvalid(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("User login with json")
    public void postLoginUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("User register with json")
    public void postRegisterUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get single user with valid id")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    @Step("Get single user with invalid id")
    public void getSingleUserInvalid(String id){
        SerenityRest.given()
                .pathParam("id",id);
    }
}
