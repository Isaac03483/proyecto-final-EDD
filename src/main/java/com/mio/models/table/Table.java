package com.mio.models.table;

import com.mio.models.bPlusTree.BPlusTree;
import com.mio.models.list.List;
import com.mio.models.list.Node;

import java.util.Objects;

public class Table {

    public String tableName;
    public List<Property> properties;
    public String key;
    public String parentName;
    public BPlusTree rows;

    public Table(String tableName, List<Property> properties, String key, String parentName) {
        this.tableName = tableName;
        this.properties = properties;
        this.key = key;
        this.parentName = parentName;
        this.rows = new BPlusTree(3);
    }

    public Table(String tableName, List<Property> properties, String key) {
        this.tableName = tableName;
        this.properties = properties;
        this.key = key;
        this.parentName = null;
        this.rows = new BPlusTree(3);
    }

    public boolean addRow(Row row){

        if(row.attributes.hasDuplicates()){
            return false;
        }

        if(!checkRow(row)){
            return false;
        }

        this.rows.insert(row.keyAttribute.value, row);

        return false;
    }

    private boolean checkRow(Row row){
        if(this.properties.size != row.attributes.size){
            return false;
        }

        Node<Attribute> attributeNode = row.attributes.firstNode;
        while(attributeNode != null){
            Property property = properties.find(attributeNode.value.property);
            if(property == null){
                return false;
            }

            if(property.propertyName.equals(this.key)){
                row.keyAttribute = attributeNode.value;
            }

            if(property.propertyType != attributeNode.value.property.propertyType){
                return false;
            }

            attributeNode = attributeNode.next;
        }

        return true;
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
