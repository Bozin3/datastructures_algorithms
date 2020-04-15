package com.bozin3.datastructuresalgorithms;

import com.bozin3.datastructuresalgorithms.datastructures.ArrayList;
import com.bozin3.datastructuresalgorithms.datastructures.DoublyLinkedList;
import com.bozin3.datastructuresalgorithms.datastructures.SinglyLinkedList;

import static com.bozin3.datastructuresalgorithms.algorithms.SortingAlgorithms.*;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add("John");
        doublyLinkedList.add("Dave");
        doublyLinkedList.add("Tom");
        System.out.println(doublyLinkedList.contains("Jerry"));
        doublyLinkedList.addFirst("Kid");
        doublyLinkedList.addLast("Jerry");
        System.out.println(doublyLinkedList.get(3));
        doublyLinkedList.isEmpty();
        doublyLinkedList.removeFirst();
        doublyLinkedList.removeLast();

    }
}
