// File: src/main/java/com/example/CustomerSegment.java
package com.example;

import java.util.ArrayList;
import java.util.List;

public class CustomerSegment {
    private static final List<CustomerSegment> _segments = new ArrayList<>();;
    public static final CustomerSegment PREMIUM = new CustomerSegment("Premium");
    public static final CustomerSegment GENERAL = new CustomerSegment("General");

    private String _segment;

    private CustomerSegment(String segment) {
        _segment = segment.toLowerCase();
        _segments.add(this);
    }

    public String getSegment() {
        return _segment;
    }

    public void setSegment(String _segment) {
        this._segment = _segment;
    }

    public static CustomerSegment valueOf(String s) {
        String lcs = s.toLowerCase();
        for (CustomerSegment segment : _segments) {
            if (segment._segment.equals(lcs)) {
                return segment;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return _segment.toString();
    }
}
