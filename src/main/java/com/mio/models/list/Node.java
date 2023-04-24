package com.mio.models.list;

import com.mio.models.table.Property;

public class Node {

    private Property value;
    private Node next;

    public Node(Property value) {
        this.value = value;
    }

    public Property getValue() {
        return value;
    }

    public void setValue(Property value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
