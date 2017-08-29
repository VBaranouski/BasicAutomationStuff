package com.expedia.automation.listener;

import com.expedia.automation.tests.DataProvider;
import com.expedia.automation.utils.RetryAnalyzer;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class aClass, Constructor constructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);

        annotation.setEnabled(true);

        if (testMethod.getName().equals("openSignInScreen"))
        {
            annotation.setEnabled(true);
            annotation.setPriority(1);

        }

        else if (testMethod.getName().equals("loginTo"))
        {
            annotation.setEnabled(true);
            annotation.setPriority(2);
        }

        else if (testMethod.getName().equals("searchFlightCheckViaDataProvider"))
        {
            annotation.setEnabled(true);
            annotation.setPriority(3);
            annotation.setDataProviderClass(DataProvider.class);
            annotation.setDataProvider("adultDestCity");
        }

        else if (testMethod.getName().equals("paramFlightCheck"))
        {
            annotation.setEnabled(true);
            annotation.setPriority(4);
        }


    }
}
