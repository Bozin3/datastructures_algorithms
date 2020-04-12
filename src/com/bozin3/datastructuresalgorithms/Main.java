package com.bozin3.datastructuresalgorithms;

import com.bozin3.datastructuresalgorithms.datastructures.ArrayList;

import static com.bozin3.datastructuresalgorithms.algorithms.SortingAlgorithms.*;

public class Main {

    public static void main(String[] args) {

        /*
            Sorting algorithms
         */
//        int[] intArray = {20,35,-15,7,55,1,-21,100};
//        recursiveInsertionSort(intArray, 1);
//        for (int i = 0; i < intArray.length; i++) {
//            System.out.println(intArray[i]);
//        }

        /*
            ArrayList
         */

        ArrayList myArrayList = new ArrayList(5);
        myArrayList.add("James");
        myArrayList.add("Steve");
        myArrayList.add("Tom");

        myArrayList.set(0,"John");
        myArrayList.add(1,"Doe");

        for(int x = 0; x < myArrayList.size(); x++){
            System.out.println(myArrayList.get(x));
        }
    }
}
