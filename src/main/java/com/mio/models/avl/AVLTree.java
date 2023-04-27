package com.mio.models.avl;


import com.mio.models.table.Table;

public class AVLTree {

    private static AVLTree avlTree;
    private TreeNode root;

    private AVLTree(){
    }

    public static AVLTree getInstance(){
        if(avlTree == null){
            avlTree = new AVLTree();
        }

        return avlTree;
    }

    public void add(Table table){
        TreeNode node = new TreeNode(table);

        if(this.root == null){
            this.root = node;
            return;
        }

        add(this.root, node);


//        postOrderBalance(this.root);

    }

//    private void balance(TreeNode node) {
//        int balanceFactor = node.getBalanceFactor();
//
//        if(balanceFactor < -1){
//            if(node.getLeft().getBalanceFactor() > 0){
//                System.out.println("Aplicando doble rotación a la izquierda");
//            } else {
//                System.out.println("Aplicando rotación simple a la izquierda");
//            }
//        } else if(balanceFactor > 1) {
//            if(node.getRight().getBalanceFactor() < 0){
//                System.out.println("Aplicando doble rotación a la derecha");
//            } else {
//                System.out.println("Aplicando rotación simple a la derecha");
//            }
//        }
//
//    }

    private void add(TreeNode currentNode, TreeNode node) {
        if(currentNode.getValue().getTableName().compareTo(node.getValue().getTableName()) == 0){
            throw new RuntimeException("No puede crear tablas con el mismo nombre.");
        }

        if(currentNode.getValue().getTableName().compareTo(node.getValue().getTableName()) < 0){
            if(currentNode.getLeft() == null){
                currentNode.setLeft(node);
                node.setFather(currentNode);
                return;
            }

            add(currentNode.getLeft(), node);
            return;
        }

        if(currentNode.getRight() == null){
            currentNode.setRight(node);
            node.setFather(currentNode);

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

//    private void postOrderBalance(TreeNode node){
//        if(node != null){
//            postOrderBalance(node.getLeft());
//            postOrderBalance(node.getRight());
//            balance(node);
//        }
//
//    }


}
