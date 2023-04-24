package com.mio.models.table;

import com.mio.models.list.PropertyList;

public class Table {
    private String tableName;
    private PropertyList properties;
    private String key;
    private Object rows;

    public Table(String tableName, PropertyList properties, String key) {
        this.tableName = tableName;
        this.properties = properties;
        this.key = key;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public PropertyList getProperties() {
        return properties;
    }

    public void setProperties(PropertyList properties) {
        this.properties = properties;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
