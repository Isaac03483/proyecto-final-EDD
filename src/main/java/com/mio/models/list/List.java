package com.mio.models.list;

import java.util.Objects;

public class List <T>{

    public Node<T> firstNode;

    public List() {
        this.firstNode = null;
    }

    public boolean add(T value){
        Node<T> node = new Node<>(value);
        if(this.firstNode == null){
            this.firstNode = node;
            return true;
        }

        return addNode(this.firstNode, node);
    }

    private boolean addNode(Node<T> currentNode, Node<T> node) {
        if(currentNode.next == null){
            currentNode.next = node;
            return true;
        }

        return addNode(currentNode.next, node);
    }

    public boolean hasDuplicates(){

        if(isEmpty()){
            return false;
        }

        Node<T> node = this.firstNode;
        while(node != null){
            Node<T> next = node.next;

            while(next != null){
                if(Objects.equals(node.value, next.value)){
                    return true;
                }
                next = next.next;
            }
            node = node.next;
        }

        return false;
    }

    public boolean isEmpty(){
        return this.firstNode == null;
    }
}
