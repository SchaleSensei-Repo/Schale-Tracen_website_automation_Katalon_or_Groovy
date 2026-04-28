package com.schale.steps

import com.schale.api.ApiService
import io.cucumber.java.en.When
import io.cucumber.java.en.Then

class ApiSteps {
    
    ApiService api = new ApiService()

    @When("I send a GET request to the main endpoint")
    def sendRequest() {
        // We store it in a context if we need it later, or just call it
        api.verifySiteIsUp()
    }

    @Then("the response status code should be 200")
    def verifyStatus() {
        // The verification is already handled inside the Keyword in this example
    }
}