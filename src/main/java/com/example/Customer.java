// File: src/main/java/com/example/Customer.java
package com.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    String name;
    String address;
    CustomerType customerType;
    InternalClassification internalClassification;
    private List<Order> orders = new ArrayList<>();
    private Order mainOrder;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public InternalClassification getInternalClassification() {
        return internalClassification;
    }

    public void setInternalClassification(InternalClassification internalClassification) {
        this.internalClassification = internalClassification;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Order getMainOrder() {
        return mainOrder;
    }

    public void setMainOrder(Order mainOrder) {
        this.mainOrder = mainOrder;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", customerType=" + customerType +
                ", internalClassification=" + internalClassification +
                ", orders=" + orders +
                ", mainOrder=" + mainOrder +
                '}';
    }
}
