package com.expedia.automation.listeners;

import com.expedia.automation.utils.RetryAnalyzer;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class aClass, Constructor constructor, Method testMethod) {

        annotation.setRetryAnalyzer(RetryAnalyzer.class);
       // annotation.setEnabled(false);

        if (testMethod.getName().equals("flightSearchViaDataProvider"))
        {
            annotation.setEnabled(false);

        }

        else if (testMethod.getName().equals("flightSearchViaParameters"))
        {
            annotation.setEnabled(false);

        }
    }

    }

