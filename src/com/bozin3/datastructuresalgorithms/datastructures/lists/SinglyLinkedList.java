package com.bozin3.datastructuresalgorithms.datastructures.lists;

public class SinglyLinkedList {
    private int size;
    private Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void add(String object) {
        if (isEmpty()) {
            head = new Node(object, null);
        } else {
            Node current = head;

            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(new Node(object));
        }
        size++;
    }

    public void add(int index, String object) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(object);
        } else if (index == size - 1) {
            addLast(object);
        } else {
            Node current = head;
            int i = 1;
            while (i < index) {
                current = current.getNext();
                i++;
            }
            Node newObj = new Node(object);
            newObj.setNext(current.getNext());
            current.setNext(newObj);
        }

        size++;
    }

    public void addFirst(String object) {
        Node newObj = new Node(object);
        if (isEmpty()) {
            head = newObj;
        } else {
            Node temp = head;
            head = newObj;
            newObj.setNext(temp);
        }
        size++;
    }

    public void addLast(String object) {
        add(object);
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public String getFirst() {
        if (isEmpty()) {
            return null;
        }

        return head.getData();
    }

    public String getLast() {
        if (isEmpty()) {
            return null;
        }

        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        return current.getData();
    }

    public String removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node firstItem = head;
        head = firstItem.getNext();
        firstItem.setNext(null);
        size--;
        return firstItem.getData();
    }

    public String removeLast() {
        if (isEmpty()) {
            return null;
        }

        if (head.getNext() == null) {
            clear();
            return null;
        }

        Node current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        Node removedItem = current.getNext();
        current.setNext(null);
        size--;
        return removedItem.getData();
    }

    public String get(int index) {

        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        int i = 0;
        while (i < index) {
            current = current.getNext();
            i++;
        }

        return current.getData();
    }

    public boolean contains(String object) {
        if (isEmpty()) {
            return false;
        }

        boolean found = true;
        Node current = head;
        while (!current.getData().equals(object)) {
            current = current.getNext();
            if (current == null) {
                found = false;
                break;
            }
        }

        return found;
    }
}
