package org.opencart;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetBooksStepDefinitions {

    private Response response;

    @Given("the 'simple books' API is available")
    public void the_simple_books_api_is_available() {
        baseURI = "https://simple-books-api.glitch.me";
    }

    @When("I send a GET request to 'books' endpoint")
    public void i_send_a_get_request_to_books_endpoint() {
        response = given().
                        when().
                            get(baseURI+"/books");
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer responseStatusCode) {
        response.then().statusCode(responseStatusCode);
    }

    @Then("the response should contain at least one book")
    public void the_response_should_contain_at_least_one_book() {
        response.then()
                .body("$", not(empty()));
    }

    @Then("the response time should be less than 2 seconds")
    public void the_response_time_should_be_less_than_2_seconds() {
        response.then()
                .time(lessThan(2000L));
    }

    @Then("each book in the response should have id, name, type, and availability")
    public void each_book_in_the_response_should_have_id_name_type_and_availability() {
        response.then()
                .body("id", everyItem(notNullValue()))
                .body("name", everyItem(notNullValue()))
                .body("type", everyItem(notNullValue()))
                .body("available", everyItem(notNullValue()));
    }

    @Then("the response should contain exactly {int} books")
    public void the_response_should_contain_exactly_books(Integer count) {
        response.then()
                .body("size()", equalTo(count));
    }

    @When("I send a POST request to {string} endpoint")
    public void i_send_a_post_request_to_endpoint(String string) {
        response = given().
                when().
                post(baseURI+"/books");
    }

    @When("I send a GET request to 'books' endpoint along with ID {int} as parameter")
    public void i_send_a_get_request_to_endpoint_along_with_id_as_parameter(Integer id) {
        response = given().
                when().
                get(baseURI+"/books/"+id);
    }
    @Then("the book details should be returned")
    public void the_book_details_should_be_returned() {
        response.then()
                .body("id", notNullValue())
                .body("name", notNullValue())
                .body("author", notNullValue())
                .body("isbn", notNullValue())
                .body("type", notNullValue())
                .body("price", notNullValue())
                .body("current-stock", notNullValue())
                .body("available", notNullValue());
    }

    @Then("error message should be returned in response body along with invalid ID {int}")
    public void error_message_should_be_returned_in_response_body_along_with_invalid_id(Integer id) {
        response.then()
                .body("error", equalTo("No book with id "+id));
    }
}
