package com.schale.api

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.ResponseObject

public class ApiService {

    /**
     * Sends a GET request to the base URL and verifies the status code
     */
    def verifySiteIsUp() {
        ResponseObject response = WS.sendRequest(findTestObject('Object Repository/API/Home Page/Home_Page'))
        
        // Check for 200 OK
        WS.verifyResponseStatusCode(response, 200)
        
        // Return the response in case we want to check the body later
        return response
    }
}