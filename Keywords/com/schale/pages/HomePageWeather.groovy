package com.schale.pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil

public class HomePageWeather {
	
	def selectCity(String city) {
		// Wait for the dropdown to be interactive
		WebUI.waitForElementPresent(findTestObject('Object Repository/Home Page/Weather Dropdown'), 10)
		
		// Select the city by its visible text
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Home Page/Weather Dropdown'), city, false)
		
		println ">>> DEBUG: Selected city: ${city}"
	}
	
	def showCity(String city) {
		// In your index.html, the script uses encodeURIComponent(loc)
		// We check if the iframe 'src' attribute now contains the city name
		String expectedUrlPart = "wttr.in/" + city
		
		String actualSrc = WebUI.getAttribute(findTestObject('Object Repository/Home Page/Weather Frame'), 'src')
		
		if (actualSrc.contains(expectedUrlPart)) {
			println ">>> DEBUG: SUCCESS - Frame source updated to ${city}"
			KeywordUtil.markPassed("Weather frame verified for ${city}")
		} else {
			println ">>> DEBUG: FAILED - Expected ${expectedUrlPart} but found ${actualSrc}"
			KeywordUtil.markFailedAndStop("Weather frame did not update correctly!")
		}
	}

}
