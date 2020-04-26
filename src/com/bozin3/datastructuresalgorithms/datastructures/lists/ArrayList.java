package com.bozin3.datastructuresalgorithms.datastructures.lists;

/*
    Simple ArrayList
    I am using String objects just for demonstration, but i can be done with generics too
 */
public class ArrayList {

    private int capacity = 10; //default
    private int size = 0; // nextIndex
    private String[] backingArray;

    public ArrayList(){
        backingArray = new String[capacity];
    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        backingArray = new String[capacity];
    }

    // O(1)
    public int size() {
        return size;
    }

    // O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    // O(n)
    public boolean contains(String object) {
        for(int x = 0; x < size; x++) {
            if(backingArray[x].equals(object)) {
                return  true;
            }
        }
        return false;
    }

    // O(1)
    public void clear() {
        backingArray = new String[capacity];
        size = 0;
    }

    // O(1)
    public String get(int index) {
        return backingArray[index];
    }

    // O(1)
    public void set(int index, String object){
        backingArray[index] = object;
    }

    // If backing array grows then its O(n), else O(1)
    public void add(String object) {
        if(size == capacity) { // grow
            increaseArraySize();
        }

        backingArray[size++] = object;
    }

    // add only works between zero index and last element index
    // O(n)
    public void add(int index, String element) {
        if(index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if(size == capacity) {
            increaseArraySize();
        }

        // Shift elements starting at (index) to right
        String[] newArray = new String[capacity];
        int x = 0;
        int y = 0;
        while (x <= size) {
            if(x == index) {
                newArray[x] = element;
            } else {
                newArray[x] = backingArray[y];
                y++;
            }
            x++;
        }
        backingArray = newArray;
        size++;
    }

    // O(n)
    public String remove(int index) {
        String removedItem = backingArray[index];
        if(index < size) {
            backingArray[index] = null;
            if (index != size - 1) {
                // it can be done with System.arrayCopy(), but i like to do it with for loop :)
                for (int x = index + 1; x < size; x++) {
                    backingArray[x - 1] = backingArray[x];
                }
            }
            size--;
        }
        return removedItem;
    }

    // O(n)
    public int indexOf(Object o) {
        for(int x = 0; x < size; x++){
            if(backingArray[x].equals(o)){
                return x;
            }
        }
        return -1;
    }

    // O(n)
    private void increaseArraySize() {
        capacity*=2;
        String[] newArray = new String[capacity];
        for(int x = 0; x < size; x++) {
            newArray[x] = backingArray[x];
        }
        backingArray = newArray;
    }
}
