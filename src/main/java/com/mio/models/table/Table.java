package com.mio.models.table;

import com.mio.models.list.List;

import java.util.Objects;

public class Table {

    public String tableName;
    public List<Property> properties;
    public String key;
    public String parentName;
    public Object rows;

    public Table(String tableName, List<Property> properties, String key, String parentName) {
        this.tableName = tableName;
        this.properties = properties;
        this.key = key;
        this.parentName = parentName;
        this.rows = null;
    }

    public Table(String tableName, List<Property> properties, String key) {
        this.tableName = tableName;
        this.properties = properties;
        this.key = key;
        this.parentName = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Table table = (Table) o;

        return Objects.equals(tableName, table.tableName);
    }

    @Override
    public int hashCode() {
        return tableName != null ? tableName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableName='" + tableName + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
