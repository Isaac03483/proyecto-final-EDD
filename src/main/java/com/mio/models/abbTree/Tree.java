package com.mio.models.abbTree;

import com.mio.models.table.Table;

public class Tree {

    public Node<Table> root;
    public static Tree tree;

    private Tree() {
    }

    public static Tree getInstance(){
        if(tree == null){
            tree = new Tree();
        }

        return tree;
    }

    public boolean add(Table table){
        if(search(table)){
            return false;
        }

        Node<Table> node = new Node<>(table);
        if(this.root == null){
            this.root = node;
            return true;
        }

        return add(this.root, node);

    }

    private boolean add(Node<Table> currentNode, Node<Table> node) {
        if(currentNode.value.tableName.compareTo(node.value.tableName) > 0){
            if(currentNode.leftChildren == null){
                currentNode.leftChildren = node;
                return true;
            }

            return add(currentNode.leftChildren, node);
        }

        if(currentNode.rightChildren == null){
            currentNode.rightChildren = node;
            return true;
        }

        return add(currentNode.rightChildren, node);
    }

    public Table getByName(String tableName){
        if(this.isEmpty()){
            return null;
        }

        return getByName(this.root, tableName);
    }

    private Table getByName(Node<Table> currentNode, String tableName){
        if(currentNode == null){
            return null;
        }

        if(currentNode.value.tableName.compareTo(tableName) == 0){
            return currentNode.value;
        }

        if(currentNode.value.tableName.compareTo(tableName) > 0){
            return getByName(currentNode.leftChildren, tableName);
        }

        return getByName(currentNode.rightChildren, tableName);
    }

    public boolean findParent(String parentName){
        return findParent(this.root, parentName);
    }

    private boolean findParent(Node<Table> currentNode, String parentName){
        if(currentNode == null){
            return false;
        }

        if(currentNode.value.tableName.equals(parentName)){
            return true;
        }

        if(currentNode.value.tableName.compareTo(parentName) < 0){
            return findParent(currentNode.rightChildren, parentName);
        }

        return findParent(currentNode.leftChildren, parentName);

    }

    public void print(){
        System.out.println("IMPRIMIENDO VALORES DEL ARBOL");
        inOrder(this.root);
    }

    private void inOrder(Node<Table> node) {
        if(node != null){
            inOrder(node.leftChildren);
            System.out.println(node.value);
            inOrder(node.rightChildren);
        }
    }

    public boolean search(Table table){
        if(this.isEmpty()){
            return false;
        }

        return search(this.root, table);
    }

    private boolean search(Node<Table> currentNode, Table table) {
        if(currentNode == null){
            return false;
        }

        if(currentNode.value.tableName.compareTo(table.tableName) == 0){
            return true;
        }

        if(currentNode.value.tableName.compareTo(table.tableName) > 0){
            return search(currentNode.leftChildren, table);
        }

        return search(currentNode.rightChildren, table);

    }

    public boolean isEmpty(){
        return this.root == null;
    }
}
