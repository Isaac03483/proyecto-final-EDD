package com.mio.models.abbTree;

public class Node<T>{

    public T value;
    public Node<T> leftChildren;
    public Node<T> rightChildren;

    public Node(T value) {
        this.value = value;
    }
}
