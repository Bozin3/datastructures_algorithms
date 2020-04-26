package com.bozin3.datastructuresalgorithms.datastructures.trees;

public class BinarySearchTree {

    private int size;
    private TreeNode root;

    public BinarySearchTree() {
        size = 0;
    }

    public BinarySearchTree(int root) {
        this.root = new TreeNode(root);
        size = 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void add(int data) {
        if (isEmpty()) {
            root = new TreeNode(data);
        } else {
            root.add(data);
        }
        size++;
    }

    public TreeNode get(int item) {
        if(isEmpty()){
            return null;
        } else {
            return root.get(item);
        }
    }

    public TreeNode getMin() {
        if(isEmpty()) {
            return null;
        }

        return root.getMin();
    }

    public TreeNode getMax() {
        if(isEmpty()) {
            return null;
        }

        return root.getMax();
    }

    // Printing all elements in order
    public void printInOrder() {
        if(!isEmpty()){
            root.printInOrder();
        }
    }

    // 1. print root 2. print left child 3. print right child
    public void printPreOrder() {
        if(!isEmpty()){
            root.printPreOrder();
        }
    }

    public TreeNode delete(int item) {
        if(isEmpty()) {
            return null;
        }

        TreeNode removedNode;
        if(root.getData() == item) {
            removedNode = root;
            root = null;
        } else {
            removedNode = root.remove(root, item);
        }

        size--;
        return removedNode;
    }

}
