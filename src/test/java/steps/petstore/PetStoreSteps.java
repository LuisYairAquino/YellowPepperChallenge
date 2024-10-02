package steps.petstore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static org.hamcrest.Matchers.*;

public class PetStoreSteps {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/pet";
    private Response response;

    @Given("The pet store API is available")
    public void petStoreApiIsAvailable() {
        response = SerenityRest.given().get(BASE_URL);
        Assert.assertEquals(200, response.statusCode());
    }

    @Step("Request a list of pets")
    public void requestListOfPets() {
        response = SerenityRest.given()
                .when().get(BASE_URL + "/findByStatus?status=available");
    }

    @Step("Add a new pet with the details")
    public void addNewPet(String name, String category, String status) {
        String body = "{ \"name\": \"" + name + "\", \"category\": {\"name\":\"" + category + "\"}, \"status\":\"" + status + "\"}";
        response = SerenityRest.given()
                .contentType("application/json")
                .body(body)
                .post(BASE_URL);
    }

    @Step("Retrieve pet by ID")
    public void retrievePetById(int petId) {
        response = SerenityRest.given()
                .when().get(BASE_URL + "/" + petId);
    }

    @Step("Update pet information with ID")
    public void updatePetById(int petId, String name, String status) {
        String body = "{ \"id\": " + petId + ", \"name\": \"" + name + "\", \"status\": \"" + status + "\"}";
        response = SerenityRest.given()
                .contentType("application/json")
                .body(body)
                .put(BASE_URL + "/" + petId);
    }

    @Step("Delete a pet by ID")
    public void deletePetById(int petId) {
        response = SerenityRest.given()
                .delete(BASE_URL + "/" + petId);
    }

    @Step("Response status should be {int}")
    public void responseStatusShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Step("Response should contain pet details")
    public void responseShouldContainPetDetails() {
        response.then().body("id", notNullValue())
                .body("name", notNullValue())
                .body("category.name", notNullValue());
    }

    @Step("Response should match the input")
    public void responseShouldMatchInput(String name, String category, String status) {
        response.then().body("name", equalTo(name))
                .body("category.name", equalTo(category))
                .body("status", equalTo(status));
    }

    @Step("Retrieving the pet should return 404 Not Found")
    public void retrievingPetShouldReturn404(int petId) {
        SerenityRest.given().get(BASE_URL + "/" + petId)
                .then().statusCode(404);
    }

    @Given("the pet store API is available")
    public void thePetStoreAPIIsAvailable() {

    }

    @When("I request a list of pets")
    public void iRequestAListOfPets() {
    }

    @Then("the response status should be {int} OK")
    public void theResponseStatusShouldBeOK(int arg0) {
    }

    @And("the response should contain pet details")
    public void theResponseShouldContainPetDetails() {
    }

    @When("I add a new pet with the following details")
    public void iAddANewPetWithTheFollowingDetails() {
    }

    @Then("the response status should be {int} Created")
    public void theResponseStatusShouldBeCreated(int arg0) {
    }

    @And("the pet data should match the input")
    public void thePetDataShouldMatchTheInput() {
    }

    @When("I retrieve a pet by ID")
    public void iRetrieveAPetByID() {
    }

    @When("I update the pet with ID {int}")
    public void iUpdateThePetWithID(int arg0) {
    }

    @And("the pet data should be updated")
    public void thePetDataShouldBeUpdated() {
    }

    @When("I delete the pet with ID {int}")
    public void iDeleteThePetWithID(int arg0) {
    }

    @Then("the response status should be {int} No Content")
    public void theResponseStatusShouldBeNoContent(int arg0) {
    }

    @And("retrieving the pet should return a {int} Not Found")
    public void retrievingThePetShouldReturnANotFound(int arg0) {
    }
}
