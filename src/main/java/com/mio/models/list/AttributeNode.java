package com.mio.models.list;

import com.mio.models.table.Attribute;

public class AttributeNode {

    public Attribute value;
    public AttributeNode next;

    public AttributeNode(Attribute value, AttributeNode next) {
        this.value = value;
        this.next = next;
    }
}
