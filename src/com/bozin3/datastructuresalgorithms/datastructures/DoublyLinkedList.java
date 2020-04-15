package com.bozin3.datastructuresalgorithms.datastructures;

public class DoublyLinkedList {
    private int size;
    private Node head;
    private Node tail;

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return size;
    }

    public void add(String object){
        if(isEmpty()){
            head = tail = new Node(object);
        }else{
            Node newNode = new Node(object,null,tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void addFirst(String object){
        Node newObj = new Node(object);
        if(isEmpty()){
            head = tail = newObj;
        }else{
            head.setPrev(newObj);
            newObj.setNext(head);
            head = newObj;
        }
        size++;
    }

    public void addLast(String object){
        add(object);
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public String getFirst(){
        if(isEmpty()){
            return null;
        }
        return head.getData();
    }

    public String getLast(){
        if(isEmpty()){
            return null;
        }
        return tail.getData();
    }

    public String removeFirst(){
        if(isEmpty()){
            return null;
        }

        Node firstItem = head;
        head = firstItem.getNext();
        head.setPrev(null);
        firstItem.setNext(null);
        size--;
        return firstItem.getData();
    }

    public String removeLast(){
        if(isEmpty()){
            return null;
        }

        // if there is only 1 item
        if(head == tail){
            clear();
            return null;
        }

        Node lastItem = tail;
        tail = lastItem.getPrev();
        tail.setNext(null);
        lastItem.setPrev(null);
        size--;
        return lastItem.getData();
    }

    public String get(int index){

        if(index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        int i = 0;
        while(i < index){
            current = current.getNext();
            i++;
        }

        return current.getData();
    }

    public boolean contains(String object){
        if(isEmpty()){
            return false;
        }

        boolean found = true;
        Node current = head;
        while (!current.getData().equals(object)){
            current = current.getNext();
            if(current == null){
                found = false;
                break;
            }
        }

        return found;
    }
}
