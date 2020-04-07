package com.bozin3.datastructuresalgorithms;

import static com.bozin3.datastructuresalgorithms.algorithms.SortingAlgorithms.*;

public class Main {

    public static void main(String[] args) {

        /*
            Sorting algorithms
         */
        int[] intArray = {20,35,-15,7,55,1,-21,100};
        recursiveInsertionSort(intArray, 1);
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
        
    }
}
