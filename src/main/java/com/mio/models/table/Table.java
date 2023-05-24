package com.mio.models.table;

import com.mio.models.bPlusTree.BPlusTree;
import com.mio.models.list.List;
import com.mio.models.list.Node;

import java.util.Objects;

public class Table {

    public String tableName;
    public List<Property> properties;
    public String key;
    public String foreign;
    public PropertyType primaryType;
    public String parentName;
    public BPlusTree rows;

    public Table(String tableName, List<Property> properties, String key, String foreign, String parentName, PropertyType primaryType) {
        this.tableName = tableName;
        this.properties = properties;
        this.key = key;
        this.foreign = foreign;
        this.parentName = parentName;
        this.rows = new BPlusTree(3,primaryType);
    }

    public Table(String tableName, List<Property> properties, String key, PropertyType primaryType) {
        this.tableName = tableName;
        this.properties = properties;
        this.key = key;
        this.parentName = null;
        this.rows = new BPlusTree(3,primaryType);
    }

    public boolean addRow(Row row){

        if(row.attributes.hasDuplicates()){
            return false;
        }

        if(!checkRow(row)){
            return false;
        }

        this.rows.insert(row.keyAttribute.value, row);
        System.out.println("\n\n\t.:IMPRIMIENTO REGISTROS ACTUALES TABLA -> "+tableName+":.");
        this.rows.printRows();
        System.out.println("\n\n.....................");
        return true;
    }

    private boolean checkRow(Row row){
        if(this.properties.size != row.attributes.size){
            return false;
        }

        Node<Attribute> attributeNode = row.attributes.firstNode;
        while(attributeNode != null){
            Property property = properties.find(attributeNode.value.property);
            if(property == null){
                System.out.println("No se encontró la propiedad");
                return false;
            }

            if(property.propertyName.equals(this.key)){
                row.keyAttribute = attributeNode.value;
//                System.out.println("Seteando la llave primaria en el registro. "+this.key);
            }

            if(property.propertyType != attributeNode.value.property.propertyType){
//                System.out.println("Los tipos de las propiedades no coinciden: "+property.propertyType + " con: "
//                        +attributeNode.value.property.propertyType);
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
