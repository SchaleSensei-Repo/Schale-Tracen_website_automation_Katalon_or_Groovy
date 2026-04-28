package com.schale.steps

import com.schale.pages.HomePage
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class HomeSteps {
    
    HomePage home = new HomePage()

    @Given("I navigate to the Schale Tracen home page")
    def navigateToHome() {
        home.navigateToHome()
    }

    @Then("I should see the main heading {string}")
	def verifyHeading(String expectedTitle) {
    home.verifyLandingPage(expectedTitle)
    WebUI.closeBrowser() // Always clean up after the test!
}
}