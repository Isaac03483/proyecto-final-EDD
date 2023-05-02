package com.mio.models.bPlusTree;

import com.mio.models.table.Row;

public class BPlusTree {

    public int max;
    public InternalNode root;
    public LeafNode firstLeaf;

    public BPlusTree(int max){
        this.max = max;
        this.root = null;
    }

    public void insert(String key, Row value){
        if(isEmpty()){
            this.firstLeaf = new LeafNode(this.max, new Pair(key, value));
            return;
        }
    }

    private Pair[] splitPair(LeafNode node, int midPoint) {
        return new Pair[0];
    }

    private int getMidPoint() {
        return (int) Math.ceil((this.max + 1) / 2.0) - 1;
    }

    private LeafNode findLeaf(String key) {

        return null;
    }

    private LeafNode findLeaf(InternalNode currentNode, String key){
        return null;
    }

    private boolean isEmpty(){
        return this.firstLeaf == null;
    }
}
