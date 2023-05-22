package com.mio.models.bPlusTree;

public class InternalNode extends Node{

    public int max;
    public int min;
    public int degree;
    public String[] keys;
    public Node[] childPointers;

    public InternalNode(int max, String[] keys) {
        this.max = max;
        this.min = (int) Math.ceil(max / 2.0);
        this.degree = 0;
        this.keys = keys;
        this.childPointers = new Node[this.max +1];
    }

    public InternalNode(int max, String[] keys, Node[] childPointers){
        this.max = max;
        this.min = (int) Math.ceil(this.max / 2.0);
        this.degree = linearNullSearch(childPointers);
        this.keys = keys;
        this.childPointers = childPointers;
    }

    public boolean isOverFull(){
        return this.degree == this.max+1;
    }

    private int linearNullSearch(Node[] childPointers) {
        for(int i = 0; i < childPointers.length; i++){
            if(childPointers[i] == null){
                return i;
            }
        }
        return -1;
    }

    public int findIndexOfPointer(Node pointer){
        for(int i = 0; i < childPointers.length; i++) {
            if(childPointers[i] == pointer){
                return i;
            }
        }
        return -1;
    }

    public void insertChildPointer(Node pointer, int index) {
        for(int i = degree; i >= index; i--) {
            childPointers[i + 1] = childPointers[i];
        }
        this.childPointers[index] = pointer;
        this.degree++;
    }

    public void appendChildPointer(Node pointer) {
        this.childPointers[degree] = pointer;
        this.degree++;
    }

    public void removePointer(int index) {
        this.childPointers[index] = null;
        this.degree--;
    }
}
