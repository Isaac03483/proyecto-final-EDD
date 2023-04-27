package com.mio.models.btree;

public class InternalNode extends Node{

    public int maxDegree;
    public int minDegree;
    public int degree;
    public String[] keys;

    public Node[] childPointers;

    public InternalNode(int maxDegree, String[] keys) {
        this.maxDegree = maxDegree;
        this.minDegree = (int) Math.ceil(maxDegree / 2.0);
        this.degree = 0;
        this.keys = keys;
        this.childPointers = new Node[this.maxDegree + 1];

    }

    public InternalNode(int maxDegree, String[] keys, Node[] childPointers) {
        this.maxDegree = maxDegree;
        this.minDegree = (int) Math.ceil(maxDegree / 2.0);
        this.degree = this.linearNullSearch(childPointers);
        this.keys = keys;
        this.childPointers = childPointers;
    }

    private int linearNullSearch(Node[] pointers) {
        for (int i = 0; i < pointers.length; i++) {
            if (pointers[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void removeChild(int index) {
        this.childPointers[index] = null;
        this.degree--;
    }
}
