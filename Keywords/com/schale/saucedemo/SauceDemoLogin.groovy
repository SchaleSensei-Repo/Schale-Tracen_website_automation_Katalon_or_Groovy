package com.schale.saucedemo

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

import internal.GlobalVariable

public class SauceDemoLogin {

	String url = GlobalVariable.baseUrlSauce

    def GoSauce() {
        WebUI.openBrowser('')
        WebUI.navigateToUrl(url)
    }
	
	def Credential() {
		WebUI.findWebElement(findTestObject('Object Repository/Sauce Demo/field_sauce_user'),
			10)
		WebUI.setText(findTestObject('Object Repository/Sauce Demo/field_sauce_user'), "standard_user")
		println ">>> DEBUG: SUCCESS - The User text field can be typed."
		WebUI.findWebElement(findTestObject('Object Repository/Sauce Demo/field_sauce_pass'),
			10)
		WebUI.setText(findTestObject('Object Repository/Sauce Demo/field_sauce_pass'), "secret_sauce")
		println ">>> DEBUG: SUCCESS - The User text field can be typed."
	}
	
	def SauceLogin() {
		WebUI.click(findTestObject('Object Repository/Sauce Demo/btn_sauce_login'))
		println ">>> DEBUG: SUCCESS - The Login Button can be clicked."
	}
	
	
	
}
