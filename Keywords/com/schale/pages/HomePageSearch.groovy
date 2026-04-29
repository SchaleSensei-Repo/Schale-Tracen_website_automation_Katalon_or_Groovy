package com.schale.pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable
import com.kms.katalon.core.model.FailureHandling

public class HomePageSearch {

    String url = GlobalVariable.baseUrl

    def navigateToHome() {
        WebUI.openBrowser('')
        WebUI.navigateToUrl(url)
		KeywordUtil.logInfo("Current URL is: " + WebUI.getUrl())
    }

    def handleSearchInput(String searchText) {
		WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Site Search'), 
        10)
    	WebUI.findWebElement(findTestObject('Object Repository/Home Page/Site Search'), 
        10)
		WebUI.setText(findTestObject('Object Repository/Home Page/Site Search'), 
		searchText)
		println ">>> DEBUG: The search term being used is: ${searchText}"
		
	}
	
	def VisibleCategory(String category) {

    def dynamicObject = findTestObject('Object Repository/Home Page/Site Content', [('categoryText') : category])
    WebUI.waitForElementVisible(dynamicObject, 3)    
    println ">>> DEBUG: SUCCESS - The visible category being used is: ${category}"
	
}
	
	def HiddenCategory(String hiddenCategory) {

		        def dynamicObject = findTestObject('Object Repository/Home Page/Site Content', [('categoryText') : hiddenCategory])
        
        if (WebUI.waitForElementNotVisible(dynamicObject, 3, FailureHandling.OPTIONAL)) {
            println ">>> DEBUG: SUCCESS - The category '${hiddenCategory}' was hidden."
            KeywordUtil.logInfo("UI Verification: ${hiddenCategory} was hidden.")
        } else {
            println ">>> DEBUG: FAILED - the category '${hiddenCategory}' was still visible."
            KeywordUtil.markFailedAndStop("Test failed: The expected category '${hiddenCategory}' did not disappear.")
        }
        
        WebUI.closeBrowser()
        println ">>> DEBUG: Closed the browser"
    }
}