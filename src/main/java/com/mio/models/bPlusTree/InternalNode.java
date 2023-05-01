package com.mio.models.bPlusTree;

public class InternalNode extends Node{

    public int max;
    public int min;
    public int degree;
    public String[] keys;
    public Node[] childPointers;
}
