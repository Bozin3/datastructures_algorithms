package com.bozin3.datastructuresalgorithms.datastructures.trees;

public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public void add(int newItem) {

        // duplicates are not allowed
        if (this.data == newItem) {
            return;
        }

        if (this.data > newItem) {
            if (getLeftChild() != null) {
                getLeftChild().add(newItem);
            } else {
                setLeftChild(new TreeNode(newItem));
            }
        } else {
            if (getRightChild() != null) {
                getRightChild().add(newItem);
            } else {
                setRightChild(new TreeNode(newItem));
            }
        }
    }

    public TreeNode get(int item) {
        if (this.data == item) {
            return this;
        }

        if (this.data > item) {
            if (getLeftChild() != null) {
                return getLeftChild().get(item);
            } else {
                return null;
            }
        } else {
            if (getRightChild() != null) {
                return getRightChild().get(item);
            } else {
                return null;
            }
        }
    }

    public TreeNode getMin() {
        if (getLeftChild() != null) {
            return getLeftChild().getMin();
        } else {
            return this;
        }
    }

    public TreeNode getMax() {
        if (getRightChild() != null) {
            return getRightChild().getMax();
        } else {
            return this;
        }
    }

    public void printInOrder() {
        if (getLeftChild() != null) {
            getLeftChild().printInOrder();
        }

        System.out.println(this.data);

        if (getRightChild() != null) {
            getRightChild().printInOrder();
        }

    }

    public void printPreOrder() {

        System.out.println(this.data);

        if (getLeftChild() != null) {
            getLeftChild().printPreOrder();
        }

        if (getRightChild() != null) {
            getRightChild().printPreOrder();
        }

    }

    public TreeNode remove(TreeNode parent, int item) {
        if (this.data == item) {

            TreeNode replacementNode = null;
            if (this.getLeftChild() == null) {
                replacementNode = this.getRightChild();
            } else if (getRightChild() == null) {
                replacementNode = this.getLeftChild();
            } else {
                /*
                    If the removed object has left and right child,
                    we always find the biggest item in the left subtree
                    and replace the left child pointer of the parent
                 */
                TreeNode maxLeftChild = this.getLeftChild().remove(this, this.getLeftChild().getMax().getData());
                maxLeftChild.setLeftChild(this.getLeftChild());
                maxLeftChild.setRightChild(this.getRightChild());
                replacementNode = maxLeftChild;
            }

            if (parent.getData() > item) {
                parent.setLeftChild(replacementNode);
            } else {
                parent.setRightChild(replacementNode);
            }

            return this; // returning current object , because its the removed object
        }

        if (this.data > item) {
            if (getLeftChild() != null) {
                return getLeftChild().remove(this, item);
            }
        } else {
            if (getRightChild() != null) {
                return getRightChild().remove(this, item);
            }
        }

        return null;
    }

}
