package com.schale.rss

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

import internal.GlobalVariable

public class FreshRssPage {
	String url = GlobalVariable.baseUrlSauceSauce
	
	def GoNews() {
		WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/News Link'),
			10)
		WebUI.findWebElement(findTestObject('Object Repository/Home Page/News Link'),
			10)
		WebUI.click(findTestObject('Object Repository/Home Page/News Link'))
		println ">>> DEBUG: SUCCESS - The News Link can be clicked."
		KeywordUtil.logInfo("UI Verification: The News Link can be clicked.")
	}
	
	def RSSLanding() {
		
		WebUI.waitForElementVisible(findTestObject('Object Repository/RSS/btn_login'),
			10)
		WebUI.findWebElement(findTestObject('Object Repository/RSS/btn_login'),
			10)
		println ">>> DEBUG: SUCCESS - The Login Button is visible."
		KeywordUtil.logInfo("UI Verification: The Login Button is visible.")
	}
	
	def Login() {
		String user = System.getenv('RSS_USER')
		String pass = System.getenv('RSS_PASS')
		
		if (user == null || pass == null) {
			KeywordUtil.markFailedAndStop("ERROR: Environment variables RSS_USER or RSS_PASS not found!")
		}
		
		WebUI.waitForElementVisible(findTestObject('Object Repository/RSS/field_user'),
			10)
		WebUI.findWebElement(findTestObject('Object Repository/RSS/field_user'),
			10)
		WebUI.setText(findTestObject('Object Repository/RSS/field_user'), user)
		println ">>> DEBUG: SUCCESS - The User text field can be typed."
		KeywordUtil.logInfo("UI Verification: The User text field can be typed.")
		WebUI.waitForElementVisible(findTestObject('Object Repository/RSS/field_pass'),
			10)
		WebUI.findWebElement(findTestObject('Object Repository/RSS/field_pass'),
			10)
		WebUI.setText(findTestObject('Object Repository/RSS/field_pass'), pass)
		println ">>> DEBUG: SUCCESS - The Password text field can be typed."
		KeywordUtil.logInfo("UI Verification: The Password text field can be typed.")
		WebUI.waitForElementVisible(findTestObject('Object Repository/RSS/btn_login'),
			10)
		WebUI.findWebElement(findTestObject('Object Repository/RSS/btn_login'),
			10)
		WebUI.click(findTestObject('Object Repository/RSS/btn_login'))
		println ">>> DEBUG: SUCCESS - The Login Button can be clicked."
		KeywordUtil.logInfo("UI Verification: The Login Button can be clicked.")
	}
	
	def RSSMenu() {
		
		WebUI.waitForElementVisible(findTestObject('Object Repository/RSS/btn_option'),
			10)
		WebUI.findWebElement(findTestObject('Object Repository/RSS/btn_option'),
			10)
		println ">>> DEBUG: SUCCESS - The Option Button is visible."
		KeywordUtil.logInfo("UI Verification: The Option Button is visible.")
	}
	
	def Logout() {
		
		WebUI.waitForElementVisible(findTestObject('Object Repository/RSS/btn_option'),
			10)
		WebUI.findWebElement(findTestObject('Object Repository/RSS/btn_option'),
			10)
		WebUI.click(findTestObject('Object Repository/RSS/btn_option'))
		println ">>> DEBUG: SUCCESS - The Option Button can be clicked."
		KeywordUtil.logInfo("UI Verification: The Option Button can be clicked.")
		WebUI.waitForElementVisible(findTestObject('Object Repository/RSS/btn_logout'),
			10)
		WebUI.findWebElement(findTestObject('Object Repository/RSS/btn_logout'),
			10)
		WebUI.click(findTestObject('Object Repository/RSS/btn_logout'))
		println ">>> DEBUG: SUCCESS - The Logout Button can be clicked."
		KeywordUtil.logInfo("UI Verification: The Logout Button can be clicked.")
	}
	
	def LoggedOut() {
		
		WebUI.waitForElementVisible(findTestObject('Object Repository/RSS/btn_login'),
			10)
		WebUI.findWebElement(findTestObject('Object Repository/RSS/btn_login'),
			10)
		println ">>> DEBUG: SUCCESS - The Login Button is visible."
		KeywordUtil.logInfo("UI Verification: The Login Button is visible.")
	}
	
	
}
