package com.mio.models.bPlusTree;

import com.mio.utils.Sort;

public class LeafNode extends Node{

    public int max;
    public int min;
    public int degree;
    public Pair[] pairs;
    public LeafNode leftSibling;
    public LeafNode rightSibling;

    public LeafNode(int max, Pair pair){
        this.min = max-1;
        this.min = (int)(Math.ceil(max/2.0) -1);
        this.pairs = new Pair[max];
        this.degree = 0;
        this.insert(pair);
    }

    private boolean insert(Pair pair) {
        if(this.isFull()){
            return false;
        }
        this.pairs[degree] = pair;
        degree++;
//        Sort(this.pairs, 0, degree);

        return true;
    }

    public LeafNode(int max, Pair[] pairs, InternalNode parent){
        this.max = max-1;
        this.min = (int) (Math.ceil(max/2.0)-1);
        this.pairs = pairs;
        this.degree = linearNullSearch(pairs);
        this.parent = parent;
    }

    public boolean isFull(){
        return this.degree == max;
    }

    private int linearNullSearch(Pair[] pairs) {
        for(int i = 0; i < pairs.length; i++){
            if(pairs[i] == null){
                return i;
            }
        }
        return 0;
    }
}