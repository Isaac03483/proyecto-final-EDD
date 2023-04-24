package com.mio.models.avl;


import com.mio.models.table.Table;

public class AVLTree {

    private TreeNode root;


    public void add(Table table){
        TreeNode node = new TreeNode(table);

        if(this.root == null){
            this.root = node;
            return;
        }

        add(this.root, node);
    }

    private void add(TreeNode currentNode, TreeNode node) {
        if(currentNode.getValue().getTableName().compareTo(node.getValue().getTableName()) == 0){
            throw new RuntimeException("No puede crear tablas con el mismo nombre.");
        }

        if(currentNode.getValue().getTableName().compareTo(node.getValue().getTableName()) < 0){
            if(currentNode.getLeft() == null){
                currentNode.setLeft(node);
                return;
            }

            add(currentNode.getLeft(), node);
            return;
        }

        if(currentNode.getRight() == null){
            currentNode.setRight(node);
            return;
        }

        add(currentNode.getRight(), node);

    }

    public int getHeight(){
        if(this.root == null){
            return 0;
        }

        return this.root.getHeight();
    }


}
