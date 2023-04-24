package com.mio.models.table;

import java.util.Objects;

public record Property(String propertyName, PropertyType propertyType) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Property property = (Property) o;

        if (!Objects.equals(propertyName, property.propertyName))
            return false;
        return propertyType == property.propertyType;
    }

    @Override
    public int hashCode() {
        int result = propertyName != null ? propertyName.hashCode() : 0;
        result = 31 * result + (propertyType != null ? propertyType.hashCode() : 0);
        return result;
    }
}
