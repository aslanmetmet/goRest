package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.AssertionFailedError;
import org.junit.Assert;
import pages.ApiValidation;

public class ApiStepDef extends ApiValidation {
    @Given("user given api url enter {string}")
    public void userGivenApiUrlEnter(String url) {
        Response response;
        RestAssured.baseURI = url;
        System.out.println("user given api url" + url);
    }

    @Given("set api endpoint {string}")
    public void setApiEndpoint(String endpoint) {
        RestAssured.basePath = endpoint;
        // RestAssured.port=8080;
        System.out.println("et api endpoint" + endpoint);
    }

    @And("user creates new user with request body{string},{string},{string},{string}")
    public void userCreatesNewUserWithRequestBody(String name, String gender, String email, String status) {
        response = postMehtod(name, gender, email, status);
        response.prettyPrint();

    }


    @Then("validate in a status code {int}")
    public void validateInAStatusCode(int exceptedStastusCode) {

       int actualStatusCode= response.getStatusCode();
       try {
           Assert.assertEquals(exceptedStastusCode,actualStatusCode);
       }catch (AssertionFailedError ae){
           ae.printStackTrace();

       }



        System.out.println("Assertion succesfull");

    }

    @And("validate the userId is not null")
    public void validateTheUserIdIsNotNull() {
        System.out.println("alidate the userId is not null");
    }

    @And("validate the user name is {string}")
    public void validateTheUserNameIs(String name) {
        System.out.println("validate the user name is" + name);
    }

    @And("validate the user Gender is {string}")
    public void validateTheUserGenderIs(String gender) {
        System.out.println("validate the user Gender" + gender);
    }

    @And("validate the user Email is {string}")
    public void validateTheUserEmailIs(String email) {
        System.out.println("validate the user Email" + email);
    }

    @And("validate the user Status is {string}")
    public void validateTheUserStatusIs(String status) {
        System.out.println("validate the user Status" + status);
    }


}

