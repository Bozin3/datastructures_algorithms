package com.bozin3.datastructuresalgorithms;

import com.bozin3.datastructuresalgorithms.datastructures.ArrayList;
import com.bozin3.datastructuresalgorithms.datastructures.SinglyLinkedList;

import static com.bozin3.datastructuresalgorithms.algorithms.SortingAlgorithms.*;

public class Main {

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add("John");
        singlyLinkedList.add("Dave");
        singlyLinkedList.add("Tom");
        singlyLinkedList.add(1,"Kate");
        System.out.println(singlyLinkedList.contains("Jerry"));
        singlyLinkedList.addFirst("Kid");
        singlyLinkedList.addLast("Jerry");
        singlyLinkedList.isEmpty();
        singlyLinkedList.removeFirst();
        singlyLinkedList.removeLast();

    }
}
