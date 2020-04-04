package com.bozin3.datastructures.sorting;

public class SortingAlgorithms {
    // O(n^2)
    public static void simpleSort(int[] array){
        for(int x = 0 ; x < array.length - 1 ; x++){
            for(int m = 0 ; m < array.length - 1 ; m++){
                if(array[m] > array[m + 1]){
                    int temp = array[m + 1];
                    array[m + 1] = array[m];
                    array[m] = temp;
                }
            }
        }

        for (int anArray : array) {
            System.out.println(anArray);
        }
    }
}
