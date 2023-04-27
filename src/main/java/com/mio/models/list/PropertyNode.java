package com.mio.models.list;

import com.mio.models.table.Property;

public class PropertyNode {

    private Property value;
    private PropertyNode next;

    public PropertyNode(Property value) {
        this.value = value;
    }

    public Property getValue() {
        return value;
    }

    public void setValue(Property value) {
        this.value = value;
    }

    public PropertyNode getNext() {
        return next;
    }

    public void setNext(PropertyNode next) {
        this.next = next;
    }
}
