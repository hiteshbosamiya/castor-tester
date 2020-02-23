// File: src/main/java/com/example/CastorTester.java
package com.example;

import java.util.Arrays;

public class CastorTester {
    public static void main(String[] args) {
        test(1); // shows the problem
        test(2); // the problem is handled for Java 5 enum but does not work for typesafe enum
        test(3); // this works for Java 5 enum as well as typesafe enum
    }

    private static void test(int testNumber) {
        System.out.println("Test " + testNumber + "..........");
        XMLProcessor xmlProcessor = new XMLProcessor();

        Customer customer = new Customer();
        customer.setName("POC Customer");
        customer.setAddress("123, ABC Street, XYZ City");
        customer.setCustomerType(CustomerType.Platinum);
        InternalClassification internalClassification = new InternalClassification();
        internalClassification.setCustomerSegment(CustomerSegment.PREMIUM);
        customer.setInternalClassification(internalClassification);
        Order o1 = new Order("101", "Damnagar", "Bangalore");
        Order o2 = new Order("102", "Ahmedabad", "Bangalore");
        customer.setOrders(Arrays.asList(o1, o2));
        customer.setMainOrder(o1);

        final String xmlFile = "customer" + testNumber + ".xml";
        final String mappingFile = "CustomerMapping" + testNumber + ".xml";

        System.out.println("    Converting object " + customer + " to XML...");
        try {
            xmlProcessor.objectToXML(customer, xmlFile, mappingFile);
        } catch (Exception e) {
            System.out.println("    Error in object to XML");
        }

        System.out.println("    Converting XML to object...");
        Customer customerFromXML = null;
        try {
            customerFromXML = (Customer) xmlProcessor.xmlToObject(xmlFile, mappingFile);
            System.out.println("    Got " + customerFromXML + " object from XML");
        } catch (Exception e) {
            System.out.println("    Error in XML to object");
        }
    }
}
