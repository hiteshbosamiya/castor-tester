// File: src/main/java/com/example/Order.java
package com.example;

public class Order {
    private String orderId;
    private String origin;
    private String target;

    public Order() {
    }

    public Order(String orderId, String origin, String target) {
        this.orderId = orderId;
        this.origin = origin;
        this.target = target;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", origin='" + origin + '\'' +
                ", target='" + target + '\'' +
                '}';
    }
}
