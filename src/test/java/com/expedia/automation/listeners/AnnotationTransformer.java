package com.expedia.automation.listeners;

import com.expedia.automation.utils.RetryAnalyzer;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class aClass, Constructor constructor, Method testMethod) {

        annotation.setEnabled(true);

        if (testMethod.getName().equals("openSignInScreen"))
        {
            annotation.setRetryAnalyzer(RetryAnalyzer.class);
            annotation.setEnabled(true);
            annotation.setPriority(1);

        }

        else if (testMethod.getName().equals("loginTo"))
        {
            annotation.setEnabled(true);
            annotation.setPriority(2);
        }

        else if (testMethod.getName().equals("flightSearchViaDataProvider"))
        {
            annotation.setEnabled(true);
            annotation.setRetryAnalyzer(RetryAnalyzer.class);
            annotation.setPriority(3);

        }

        else if (testMethod.getName().equals("flightSearchViaParameters"))
        {
            annotation.setRetryAnalyzer(RetryAnalyzer.class);
            annotation.setEnabled(true);
            annotation.setPriority(4);
        }
    }
}
