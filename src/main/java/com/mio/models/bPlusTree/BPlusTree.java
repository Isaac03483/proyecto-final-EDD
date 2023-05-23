package com.mio.models.bPlusTree;

import com.mio.models.table.PropertyType;
import com.mio.models.table.Row;
import com.mio.utils.Sort;

//import java.util.Arrays;

public class BPlusTree {

    public int max;
    public PropertyType primaryType;
    public InternalNode root;
    public LeafNode firstLeaf;

    public BPlusTree(int max, PropertyType primaryType){
        this.max = max;
        this.primaryType=primaryType;
        this.root = null;
    }

    /**
     * Dada una llave y un valor tipo Row, este método inserta
     * un objeto Pair en el árbol B+
     * @param key valor String que representa el valor de la llave
     * @param value valor Row que conforma el conjunto de atributos del registro
     */
    public void insert(String key, Row value){
        if(isEmpty()){
            this.firstLeaf = new LeafNode(this.max, new Pair(key, value, primaryType));
        } else {
            LeafNode leafNode = this.root == null ? this.firstLeaf : findLeaf(key);
            if (!leafNode.insert(new Pair(key, value, primaryType))) {
                leafNode.pairs[leafNode.degree] = new Pair(key, value, primaryType);
                leafNode.degree++;
//                Arrays.sort(leafNode.pairs);
                Sort.sort(leafNode.pairs, primaryType);

                int midPoint = getMidPoint();
                Pair[] half = splitPair(leafNode, midPoint);

                if (leafNode.parent == null) {
                    String[] parentKeys = new String[this.max];
                    parentKeys[0] = half[0].key;

                    InternalNode parent = new InternalNode(this.max, parentKeys);

                    leafNode.parent = parent;

                    parent.appendChildPointer(leafNode);
                } else {
                    String newParentKey = half[0].key;
                    leafNode.parent.keys[leafNode.parent.degree - 1] = newParentKey;

//                    Arrays.sort(leafNode.parent.keys, 0, leafNode.parent.degree);

                    System.out.println("ORDENANDO LLAVES");
                    Sort.sort(leafNode.parent.keys, 0, leafNode.parent.degree, primaryType);
                }

                LeafNode newLeafNode = new LeafNode(this.max, half, leafNode.parent);

                int pointerIndex = leafNode.parent.findIndexOfPointer(leafNode) + 1;

                leafNode.parent.insertChildPointer(newLeafNode, pointerIndex);

                newLeafNode.rightSibling = leafNode.rightSibling;

                if (newLeafNode.rightSibling != null) {
                    newLeafNode.rightSibling.leftSibling = newLeafNode;
                }

                leafNode.rightSibling = newLeafNode;
                newLeafNode.leftSibling = leafNode;

                if (this.root == null) {
                    this.root = leafNode.parent;
                } else {
                    InternalNode internalNode = leafNode.parent;
                    while (internalNode != null) {

                        if (internalNode.isOverFull()) {
                            splitInternalNode(internalNode);
                        } else {
                            break;
                        }

                        internalNode = internalNode.parent;

                    }

                }

            }

        }
    }

    /**
     * Este método es utilizado cuando se inserta un valor en el árbol B+ para corregir
     * cuando se encuentra lleno un nodo.
     * @param internalNode un nodo interno lleno que necesita ser dividido
     */
    private void splitInternalNode(InternalNode internalNode) {
        InternalNode parent = internalNode.parent;

        int midPoint = getMidPoint();
        String newParentKey = internalNode.keys[midPoint];
        String[] halfKeys = splitKeys(internalNode.keys, midPoint);
        Node[] halfPointers = splitChildPointers(internalNode, midPoint);

        internalNode.degree = linearNullSearch(internalNode.childPointers);

        InternalNode sibling = new InternalNode(this.max, halfKeys, halfPointers);
        for(Node pointer: halfPointers){
            if(pointer != null){
                pointer.parent = sibling;
            }
        }

        if(parent == null) {
            String[] keys = new String[this.max];
            keys[0] = newParentKey;
            InternalNode newRoot = new InternalNode(this.max, keys);
            newRoot.appendChildPointer(internalNode);
            newRoot.appendChildPointer(sibling);
            this.root = newRoot;

            internalNode.parent = newRoot;
            sibling.parent = newRoot;
        } else {
            parent.keys[parent.degree - 1] = newParentKey;
//            Arrays.sort(parent.keys, 0, parent.degree);
            Sort.sort(parent.keys,  0, parent.degree, primaryType);
            int pointerIndex = parent.findIndexOfPointer(internalNode) + 1;
            parent.insertChildPointer(sibling, pointerIndex);
            sibling.parent = parent;
        }
    }

    /**
     * Este método utiliza una búsqueda lineal en un arreglo de punteros hijos
     * y retorna el valor del primer puntero null que encuentra. de lo contrario
     * retorna -1. Este método se utiliza
     * @param childPointers
     * @return
     */
    private int linearNullSearch(Node[] childPointers) {
        for(int i = 0; i < childPointers.length-1; i++){
            if(childPointers[i] == null) {
                return i;
            }
        }
        return -1;
    }


    /**
     *Este método modifica el nodo interno enviado removiendo todos los punteros
     * hijos que posee después del punto medio 'midPoint'. Este método retorna
     * los punteros removidos en una lista de nodos que es utilizada  para
     * construir un nuevo nodo interno.
     * @param internalNode
     * @param midPoint
     * @return
     */
    private Node[] splitChildPointers(InternalNode internalNode, int midPoint) {
        Node[] pointers = internalNode.childPointers;
        Node[] halfPointers = new Node[this.max +1];

        for(int i = midPoint + 1; i < pointers.length; i++) {
            halfPointers[i - midPoint - 1] = pointers[i];
            internalNode.removePointer(i);
        }

        return halfPointers;
    }

    /**
     * Este método se usa cuando se divide un nodo interno, su objetivo
     * es dividir un arreglo de llaves a la mitad, y se retorna la segunda
     * mitad de las llaves.
     * @param keys
     * @param midPoint
     * @return
     */
    private String[] splitKeys(String[] keys, int midPoint) {
        String[] halfKeys = new String[this.max];
        keys[midPoint] = null;

        for( int i = midPoint+1; i < keys.length; i++) {
            halfKeys[i - midPoint - 1] = keys[i];
            keys[i] = null;
        }

        return halfKeys;
    }

    /**
     * Este método es usado principalmente para dividir un nodo en el árbol B+.
     * El método retorna la segunda mitad del arreglo eliminado del nodo hoja.
     *
     * @param node
     * @param midPoint
     * @return
     */
    private Pair[] splitPair(LeafNode node, int midPoint) {
        Pair[] pairs = node.pairs;
        Pair[] halfPair = new Pair[this.max];

        for(int i = midPoint; i < pairs.length; i++){
            halfPair[i-midPoint] = pairs[i];
            node.delete(i);
        }
        return halfPair;
    }

    /**
     * método que retorna el valor medio del máximo que admite el arbol B+
     * @return
     */
    private int getMidPoint() {
        return (int) Math.ceil((this.max + 1) / 2.0) - 1;
    }

    /**
     * Método que busca el nodo hoja en el que debe realizar alguna operación
     * Comienza a partir de la raíz 'root' y va llamando a un método recursivo
     * hasta llegar a la hoja correcta.
     * @param key
     * @return el nodo hoja que contiene la llave en el pair.
     */
    private LeafNode findLeaf(String key) {

        String[] keys = this.root.keys;
        int index;

        for(index = 0; index < this.root.degree-1; index++){
            System.out.println("COMPARANDO FINDLEAF: "+key+". CON: "+keys[index]+". PROPERTY: "+primaryType);
            System.out.println(Sort.compare(key,keys[index], primaryType));
            if(Sort.compare(key,keys[index], primaryType)){
//            if(key.compareTo(keys[index]) < 0){
                break;
            }
        }

        Node child = this.root.childPointers[index];
        System.out.println("CHILD INSTANCE LEAF: "+(child instanceof LeafNode));
        if(child instanceof LeafNode){
            return (LeafNode) child;
        }

        return findLeaf((InternalNode) child, key);
    }

    /**
     * método recursivo que realiza lo mismo que el anterior
     * sin embargo este recibe el nodo interno actual  que se está evaluando
     * @param currentNode
     * @param key
     * @return
     */
    private LeafNode findLeaf(InternalNode currentNode, String key){
        String[] keys = currentNode.keys;
        int index;

        for(index = 0; index < currentNode.degree-1; index++){
//            if(key.compareTo(keys[index]) < 0) break;
            System.out.println("COMPARANDO CURRENTNODE: "+key+". CON: "+keys[index]+". PROPERTY: "+primaryType);
            System.out.println(Sort.compare(key,keys[index], primaryType));

            if(Sort.compare(key,keys[index], primaryType)) break;
        }

        Node child = currentNode.childPointers[index];
        if(child instanceof LeafNode){
            return (LeafNode) child;
        }

        return findLeaf((InternalNode) child, key);
    }

    private boolean isEmpty(){
        return this.firstLeaf == null;
    }

    public void printRows(){
        printRows(this.firstLeaf);
    }

    public void printRows(LeafNode leafNode){
        if(leafNode != null){
            for(int i = 0; i < leafNode.degree; i++){
                if(leafNode.pairs[i] != null)
                    System.out.println(leafNode.pairs[i].value.keyAttribute.value);
            }

            printRows(leafNode.rightSibling);
        }
    }
}
