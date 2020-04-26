package com.bozin3.datastructuresalgorithms.datastructures.lists;

public class Queue {

    private DoublyLinkedList doublyLinkedList;

    public Queue() {
        doublyLinkedList = new DoublyLinkedList();
    }

    public void enqueue(String item) {
        doublyLinkedList.addLast(item);
    }

    public String dequeue() {
        // returns the first item in the list after removing it
        return doublyLinkedList.removeFirst();
    }

    public String peek() {
        return doublyLinkedList.getFirst();
    }

    public boolean isEmpty() {
        return doublyLinkedList.isEmpty();
    }

    public int size() {
        return doublyLinkedList.size();
    }
}
