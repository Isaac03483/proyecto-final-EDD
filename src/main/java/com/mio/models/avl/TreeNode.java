package com.mio.models.avl;

import com.mio.models.table.Table;

public class TreeNode {

    private Table value;
    private TreeNode left;
    private TreeNode right;
    private int balanceFactor;

    public TreeNode(Table value) {
        this.value = value;
    }

    public int getHeight(){
        if(this.left == null && this.right == null){
            return 1;
        }

        if(this.left == null){
            int rightValue = this.right.getHeight();
            return rightValue+1;
        }

        if(this.right == null){
            int leftValue = this.left.getHeight();
            return leftValue+1;
        }

        int leftValue = this.left.getHeight();
        int rightValue = this.right.getHeight();

        return Math.max(leftValue, rightValue) +1;

    }



    public Table getValue() {
        return value;
    }

    public void setValue(Table value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
