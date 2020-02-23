// File: src/main/java/com/example/InternalClassification.java
package com.example;

public class InternalClassification {
    CustomerSegment customerSegment;

    public CustomerSegment getCustomerSegment() {
        return customerSegment;
    }

    public void setCustomerSegment(CustomerSegment customerSegment) {
        this.customerSegment = customerSegment;
    }

    @Override
    public String toString() {
        return customerSegment.toString();
    }
}
