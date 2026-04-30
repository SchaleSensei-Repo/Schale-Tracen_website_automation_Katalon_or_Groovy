package com.schale.steps

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.schale.api.FloatRatesPage
import io.cucumber.java.en.When
import io.cucumber.java.en.And
import io.cucumber.java.en.Then
import com.kms.katalon.core.testobject.ResponseObject

class FloatRatesSteps {
    FloatRatesPage ratesApi = new FloatRatesPage()
    ResponseObject lastResponse

    @When("I request the latest USD exchange rates")
    def requestRates() {
        lastResponse = WS.sendRequest(findTestObject('Object Repository/API/Get_USD_Rates'))
    }

    @Then("the response status should be 200")
    def verifyStatus() {
        WS.verifyResponseStatusCode(lastResponse, 200)
    }

    @Then("the IDR exchange rate should be a valid number")
    @And("the IDR rate should be within a reasonable range")
    def verifyIdr() {
        ratesApi.verifyIdrRate(lastResponse)
    }
}