package com.mio.models.btree;

import com.mio.controllers.MainController;
import com.mio.models.table.Row;
import com.mio.utils.Sort;

public class BPlusTree {

    public int max;
    public InternalNode root;
    public LeafNode firstLeaf;

    public BPlusTree(int max) {
        this.max = max;
        this.root = null;
    }

    public void insert(String key, Row value){

        if(this.isEmpty()){

            this.firstLeaf = new LeafNode(this.max, new DictionaryPair(key, value));
            return;
        }

        LeafNode node = this.root == null? this.firstLeaf: findLeaf(key);

        if(node.insert(new DictionaryPair(key,value))){
            return;
        }

        node.dictionaryPairs[node.numPairs] =new DictionaryPair(key,value);
        node.numPairs++;
        Sort.bubbleSort(node.dictionaryPairs);

        int middle = getMiddlePoint();
    }

    private int getMiddlePoint() {
        return (int) Math.ceil((this.max +1) /2.0) -1;
    }

    private LeafNode findLeaf(String key){
        String[] keys = this.root.keys;

        int i = 0;

        while(i < this.root.degree-1){
            if(key.compareTo(keys[i]) < 0){
                break;
            }
            i++;
        }

        Node child  = this.root.childPointers[i];
        if(child instanceof LeafNode){
            return (LeafNode) child;
        }

        return findLeaf((InternalNode) child, key);
    }

    private LeafNode findLeaf ( InternalNode node, String key){

        String[] keys = node.keys;
        int i=0;

        while(i < node.degree -1){
            if(key.compareTo(keys[i]) < 0){
                break;
            }
            i++;
        }

        Node childNode = node.childPointers[i];

        if (childNode instanceof LeafNode) {
            return (LeafNode) childNode;
        }

        return findLeaf((InternalNode) node.childPointers[i], key);

    }

    public boolean isEmpty(){
        return this.firstLeaf == null;
    }

}
