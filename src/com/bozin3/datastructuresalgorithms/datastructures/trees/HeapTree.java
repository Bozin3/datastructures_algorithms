package com.bozin3.datastructuresalgorithms.datastructures.trees;

/*
    Max heap tree
 */
public class HeapTree {

    private int[] backingArray;
    private int size;

    public HeapTree(int capacity){
        this.backingArray = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Array is empty");
            return -1;
        }

        return backingArray[0];
    }

    public boolean insert(int item) {
        if(size >= backingArray.length){
            System.out.println("Insert failed because array is full");
            return false;
        }

        backingArray[size] = item;

        // fix if inserted value is bigger then its parents
        fixArrayAbove(size);

        size++;
        return true;
    }

    public int remove(int itemIndex) {
        if(isEmpty() || itemIndex > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        int removedItem = backingArray[itemIndex];

        // swap last item with the index of the removed item and fix the heap tree structure
        backingArray[itemIndex] = backingArray[size - 1];
        backingArray[size - 1] = 0; // remove value from last index

        if(backingArray[itemIndex] > backingArray[getParentIndex(itemIndex)]){
            fixArrayAbove(itemIndex);
        } else {
            fixArrayBellow(itemIndex, size - 1);
        }

        size--;
        return removedItem;
    }

    public int[] sort() {
        int lastIndex = size - 1;

        while(lastIndex > 0) {
            int temp = backingArray[lastIndex];
            backingArray[lastIndex] = backingArray[0];
            backingArray[0] = temp;
            lastIndex--;
            fixArrayBellow(0, lastIndex);
        }

        return backingArray;
    }

    private void fixArrayAbove(int currentItemIndex) {

        int currentItemValue = backingArray[currentItemIndex];

        int parentIndex = getParentIndex(currentItemIndex);
        while(currentItemValue > backingArray[parentIndex]){
            backingArray[currentItemIndex] = backingArray[parentIndex];
            currentItemIndex = parentIndex;

            if(currentItemIndex == 0) {
                break; // if parentIndex is 0 here , that means that we already check the root object
            }
            parentIndex = getParentIndex(currentItemIndex);
        }

        backingArray[currentItemIndex] = currentItemValue;
    }

    private void fixArrayBellow(int currentItemIndex, int lastItemIndex) {
        int currentItemValue = backingArray[currentItemIndex];

        while(currentItemIndex <= lastItemIndex) {
            int replacementChildIndex = currentItemIndex;

            int leftChildIndex = getLeftChild(currentItemIndex);
            int rightChildIndex = getRightChild(currentItemIndex);

            if(leftChildIndex <= lastItemIndex) {
                if(rightChildIndex <= lastItemIndex) {
                    // these means current item has left and right child
                    // get bigger item between left and right child
                    replacementChildIndex =
                            backingArray[leftChildIndex] > backingArray[rightChildIndex]
                                    ? leftChildIndex : rightChildIndex;
                } else {
                    // these is when current item has only left child
                    if(currentItemValue < backingArray[leftChildIndex]) {
                        replacementChildIndex = leftChildIndex;
                    } else {
                        break;
                    }
                }
            } else {
                // these is when there are no children
                break;
            }

            int temp = backingArray[replacementChildIndex];
            backingArray[replacementChildIndex] = backingArray[currentItemIndex];
            backingArray[currentItemIndex] = temp;
            currentItemIndex = replacementChildIndex;
        }
    }

    private int getParentIndex(int currentItemIndex) {
        return ((currentItemIndex - 1)  / 2);
    }

    private int getLeftChild(int currentItemIndex) {
        return 2*currentItemIndex +1;
    }

    private int getRightChild(int currentItemIndex) {
        return 2*currentItemIndex +2;
    }
}
