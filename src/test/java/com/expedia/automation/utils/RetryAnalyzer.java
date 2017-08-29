package com.expedia.automation.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int retryCount = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        System.out.println(iTestResult.getName() + ": test seems failed... retrying");
        if (0 < retryCount){
            retryCount--;
            return true;
        }
        return false;
    }
}
