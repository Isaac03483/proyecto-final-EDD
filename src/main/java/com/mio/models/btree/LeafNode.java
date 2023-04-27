package com.mio.models.btree;

import com.mio.utils.Sort;

import java.util.Arrays;

public class LeafNode extends Node{

    public int maxNumPairs;
    public int minNumPairs;
    public int numPairs;
    public LeafNode leftSibling;
    public LeafNode rightSibling;
    public DictionaryPair[] dictionaryPairs;

    public LeafNode(int maxNumPairs, DictionaryPair dictionary) {
        this.maxNumPairs = maxNumPairs-1;
        this.minNumPairs = (int) (Math.ceil(maxNumPairs / 2.0) - 1);
        this.dictionaryPairs = new DictionaryPair[maxNumPairs];
        this.insert(dictionary);
        numPairs++;
    }

    public LeafNode(int maxNumPairs, DictionaryPair[] dictionaryPairs, InternalNode parent) {
        this.maxNumPairs = maxNumPairs-1;
        this.minNumPairs = (int) (Math.ceil(maxNumPairs / 2.0) - 1);
        this.numPairs = this.countDictionaries(dictionaryPairs);
        this.dictionaryPairs = dictionaryPairs;
        this.parent = parent;
    }

    public boolean insert(DictionaryPair dictionary) {

        if (this.isFull()) {
            return false;
        } else {
            this.dictionaryPairs[numPairs] = dictionary;
            numPairs++;
            Sort.bubbleSort(this.dictionaryPairs, 0, numPairs);
            return true;
        }
    }

    public boolean isFull(){
        return this.numPairs == this.maxNumPairs;
    }

    private int countDictionaries(DictionaryPair[] dps) {
        for (int i = 0; i < dps.length; i++) {
            if (dps[i] == null) {
                return i;
            }
        }
        return 0;
    }
}
