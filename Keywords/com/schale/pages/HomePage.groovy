package com.schale.pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

public class HomePage {

    String url = GlobalVariable.baseUrl

    def navigateToHome() {
        WebUI.openBrowser('')
        WebUI.navigateToUrl(url)
    }

    def verifyLandingPage(String expectedText) {
    // findTestObject searches the Repository folder structure
    boolean isPresent = WebUI.verifyElementPresent(
        findTestObject('Object Repository/Home Page/header_SchaleTracen'), 
        10
    )
    return isPresent
}
}