package com.bozin3.datastructuresalgorithms.algorithms;

public class SortingAlgorithms {
    // O(n^2)
    public static void simpleSort(int[] array){
        for(int x = 0 ; x < array.length - 1 ; x++){
            for(int i = 0 ; i < array.length - 1 ; i++){
                if(array[i] > array[i + 1]){
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
        }

        for (int item : array) {
            System.out.println(item);
        }
    }

    // O(n^2)
    public static void bubbleSort(int[] array){
        for(int lastUnorderedIndex = array.length -1  ;
            lastUnorderedIndex > 0 ;
            lastUnorderedIndex--){
            for(int i = 0 ; i < lastUnorderedIndex; i++){
                if(array[i] > array[i + 1]){
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
        }

        for (int item : array) {
            System.out.println(item);
        }
    }

    // O(n^2)
    public static void selectionSort(int[] array){
        for(int lastUnorderedIndex = array.length -1  ;
            lastUnorderedIndex > 0 ;
            lastUnorderedIndex--){

            int biggestNumIndex = 0;
            for(int i = 1 ; i <= lastUnorderedIndex; i++){
                if(array[i] > array[biggestNumIndex]){
                    biggestNumIndex = i;
                }
            }
            // swap the biggest number in the partition with the item at lastUnorderedIndex
            if(biggestNumIndex != lastUnorderedIndex) {
                int temp = array[lastUnorderedIndex];
                array[lastUnorderedIndex] = array[biggestNumIndex];
                array[biggestNumIndex] = temp;
            }
        }

        for (int item : array) {
            System.out.println(item);
        }
    }

    // O(n^2)
    public static void insertionSort(int[] array){
        for(int firstUnsortedIndex = 1; // if the array has 1 item, then its sorted
            firstUnsortedIndex < array.length;
            firstUnsortedIndex ++){

            int element = array[firstUnsortedIndex];
            int swapPos = -1;

            for(int i = firstUnsortedIndex ; i > 0 && array[i - 1] > element; i--){
                array[i] = array[i - 1];
                swapPos = i - 1;
            }

            if(swapPos != -1) {
                array[swapPos] = element;
            }
        }

        for (int item : array) {
            System.out.println(item);
        }
    }

    // Worst case O(n^2) , but it can perform much better than that
    public static void shellSort(int[] array){
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int newElement = array[i];
                int j = i;

                while (j >= gap && array[j - gap] > newElement) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                array[j] = newElement;
            }
        }
        for (int item : array) {
            System.out.println(item);
        }
    }

}
