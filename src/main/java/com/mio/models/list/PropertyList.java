package com.mio.models.list;

import com.mio.models.table.Property;

public class PropertyList {

    private Node first;

    public PropertyList() {
    }

    public void add(Property value){
        Node node = new Node(value);
        if(this.first == null){
            this.first = node;
            return;
        }

        add(this.first, node);
    }

    private void add(Node currentNode, Node node) {
        if(currentNode.getValue() == node.getValue()){
            throw new RuntimeException("No puede agregar propiedades con el mismo nombre");
        }

        if(currentNode.getNext() == null){

            currentNode.setNext(node);
            return;
        }

        add(currentNode.getNext(), node);
    }
}
