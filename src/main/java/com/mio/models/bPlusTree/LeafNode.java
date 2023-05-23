package com.mio.models.bPlusTree;

import com.mio.utils.Sort;

import java.util.Arrays;

public class LeafNode extends Node{

    public int max;
    public int min;
    public int degree;
    public Pair[] pairs;
    public LeafNode leftSibling;
    public LeafNode rightSibling;

    public LeafNode(int max, Pair pair){
        this.max = max-1;
        this.min = (int)(Math.ceil(max/2.0) -1);
        this.pairs = new Pair[max];
        this.degree = 0;
        this.insert(pair);
    }

    public LeafNode(int max, Pair[] pairs, InternalNode parent){
        this.max = max-1;
        this.min = (int) (Math.ceil(max/2.0)-1);
        this.pairs = pairs;
        this.degree = linearNullSearch(pairs);
        this.parent = parent;
    }

    public boolean insert(Pair pair) {
        if(this.isFull()){
            return false;
        }
        this.pairs[degree] = pair;
        degree++;
//        Arrays.sort(this.pairs, 0, degree);
        Sort.sort(this.pairs, 0, degree,this.pairs[0].primaryType);

        printPairs();
        return true;
    }

    public void delete(int index){
        this.pairs[index] = null;
        degree--;
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

    private void printPairs(){
        for(int i = 0; i < degree; i++){
            System.out.println("LLAVE DEL VALOR: "+pairs[i].key);
        }
    }
}
