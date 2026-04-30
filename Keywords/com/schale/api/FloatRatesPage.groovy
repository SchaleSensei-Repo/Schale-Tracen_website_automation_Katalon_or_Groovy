package com.schale.api

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import groovy.json.JsonSlurper

public class FloatRatesPage {

    def verifyIdrRate(ResponseObject response) {
        // 1. Parse the JSON response
        def jsonResponse = new JsonSlurper().parseText(response.getResponseText())
        
        // 2. Floatrates returns an object where each currency is a key
        // We access the 'idr' object
        def idrData = jsonResponse.idr
        
        if (idrData == null) {
            KeywordUtil.markFailedAndStop("IDR data not found in the API response!")
        }

        double rate = idrData.rate
        String name = idrData.name

        println ">>> DEBUG: Current Rate for ${name}: ${rate}"

        // 3. Financial Industry Check: Ensure the rate is a positive number
        if (rate > 10000) { // Standard IDR range check
            KeywordUtil.logInfo("IDR Rate is valid: " + rate)
        } else {
            KeywordUtil.markFailedAndStop("IDR Rate seems suspiciously low: " + rate)
        }
    }
}