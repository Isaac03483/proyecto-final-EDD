package com.mio.models.table;

import java.util.Objects;

public class Attribute {

    public String value;
    public Property property;

    public Attribute(String value, Property property) {
        this.value = value;
        this.property = property;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attribute attribute = (Attribute) o;

        return Objects.equals(property, attribute.property);
    }

    @Override
    public int hashCode() {
        return property != null ? property.hashCode() : 0;
    }
}
