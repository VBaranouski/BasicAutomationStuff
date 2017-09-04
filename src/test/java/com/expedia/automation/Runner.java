package com.expedia.automation;

import com.expedia.automation.tests.flights.FlightsTests;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public void runTestNGTest() {


        TestNG myTestNG = new TestNG();

        XmlSuite mySuite = new XmlSuite();
        mySuite.setName("Suite_one_Programmatically");

        XmlTest myTest = new XmlTest(mySuite);
        myTest.setName("ExpediaFullProgremmatically");


      // List<XmlGroups> myGroups = new ArrayList<XmlGroups>();
      // myGroups.add(new XmlGroups("full"));


        List<XmlClass> myClasses = new ArrayList<XmlClass>();
        myClasses.add(new XmlClass("com.expedia.automation.tests.Testing"));
        myTest.setXmlClasses(myClasses);

        List<XmlTest> myTests = new ArrayList<XmlTest>();
        myTests.add(myTest);
        mySuite.setTests(myTests);

        List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
        mySuites.add(mySuite);
        myTestNG.setXmlSuites(mySuites);

        myTestNG.run();


    }
        public void runTestNGTestEasierWay() {
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] {FlightsTests.class});
        testng.run();


    }

    public static void main(String args[]) {
        Runner prRun = new Runner();
        prRun.runTestNGTest();


    }

}
