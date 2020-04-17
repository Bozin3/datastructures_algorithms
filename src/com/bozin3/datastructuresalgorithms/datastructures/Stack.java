package com.bozin3.datastructuresalgorithms.datastructures;

public class Stack {

    private SinglyLinkedList singlyLinkedList;

    public Stack(){
        singlyLinkedList = new SinglyLinkedList();
    }

    public void push(String item) {
        singlyLinkedList.addFirst(item);
    }

    public String pop() {
        return singlyLinkedList.removeFirst();
    }

    public String peek() {
        return singlyLinkedList.getFirst();
    }

    public boolean isEmpty() {
        return singlyLinkedList.isEmpty();
    }

    public int size() {
        return singlyLinkedList.size();
    }
}
