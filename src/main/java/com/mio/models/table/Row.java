package com.mio.models.table;

import com.mio.models.list.AttributeNode;

public class Row {

    public AttributeNode firstAttribute;
    public Attribute key;


    public Attribute findById(String name){
        AttributeNode attributeNode = this.firstAttribute;
        while(attributeNode != null){
            if(attributeNode.value.property.propertyName().equals(name)){
                return attributeNode.value;
            }

            attributeNode = attributeNode.next;
        }

        return null;
    }

}
