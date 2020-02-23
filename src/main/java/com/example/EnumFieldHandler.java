// File: src/main/java/com/example/EnumFieldHandler.java
package com.example;

import org.exolab.castor.mapping.GeneralizedFieldHandler;

public class EnumFieldHandler extends GeneralizedFieldHandler {
    @Override
    public Object convertUponGet(Object o) {
        return o;
    }

    @Override
    public Object convertUponSet(Object o) {
        if (o instanceof String) {
            String s = ((String) o).trim();
            Object ret = CustomerSegment.valueOf(s);
            return ret;
        }
        return o;
    }

    @Override
    public Class getFieldType() {
        return null;
    }
}
