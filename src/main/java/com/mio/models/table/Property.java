package com.mio.models.table;

import java.util.Objects;

public class Property {

    public String propertyName;
    public PropertyType propertyType;

    public Property() {
    }

    public Property(String propertyName, PropertyType propertyType) {
        this.propertyName = propertyName;
        this.propertyType = propertyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Property property = (Property) o;

        return Objects.equals(propertyName, property.propertyName);
    }

    @Override
    public int hashCode() {
        return propertyName != null ? propertyName.hashCode() : 0;
    }
}
