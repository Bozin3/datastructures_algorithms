package com.bozin3.datastructuresalgorithms.algorithms;

public class SortingAlgorithms {
    // O(n^2)
    public static void simpleSort(int[] array) {
        for (int x = 0; x < array.length - 1; x++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
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
    public static void bubbleSort(int[] array) {
        for (int lastUnorderedIndex = array.length - 1;
             lastUnorderedIndex > 0;
             lastUnorderedIndex--) {
            for (int i = 0; i < lastUnorderedIndex; i++) {
                if (array[i] > array[i + 1]) {
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
    public static void selectionSort(int[] array) {
        for (int lastUnorderedIndex = array.length - 1;
             lastUnorderedIndex > 0;
             lastUnorderedIndex--) {

            int biggestNumIndex = 0;
            for (int i = 1; i <= lastUnorderedIndex; i++) {
                if (array[i] > array[biggestNumIndex]) {
                    biggestNumIndex = i;
                }
            }
            // swap the biggest number in the partition with the item at lastUnorderedIndex
            if (biggestNumIndex != lastUnorderedIndex) {
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
    public static void insertionSort(int[] array) {
        for (int firstUnsortedIndex = 1; // if the array has 1 item, then its sorted
             firstUnsortedIndex < array.length;
             firstUnsortedIndex++) {

            int element = array[firstUnsortedIndex];
            int swapPos = -1;

            for (int i = firstUnsortedIndex; i > 0 && array[i - 1] > element; i--) {
                array[i] = array[i - 1];
                swapPos = i - 1;
            }

            if (swapPos != -1) {
                array[swapPos] = element;
            }
        }

        for (int item : array) {
            System.out.println(item);
        }
    }

    public static void recursiveInsertionSort(int[] array, int firstUnsortedIndex) {
        if(firstUnsortedIndex == array.length){
            return;
        }

        int element = array[firstUnsortedIndex];
        int swapPos = -1;

        for (int i = firstUnsortedIndex; i > 0 && array[i - 1] > element; i--) {
            array[i] = array[i - 1];
            swapPos = i - 1;
        }

        if (swapPos != -1) {
            array[swapPos] = element;
        }
        recursiveInsertionSort(array,++firstUnsortedIndex);
    }

    /*
        O(n)
        these algorithm is best for small arrays
        and small range between min possible and max possible value
     */
    public static void countingSort(int[] array, int min, int max){
        int[] counterArray = new int[(max - min) + 1];
        for(int i = 0; i < array.length; i++){
            counterArray[array[i] - min] += 1;
        }

        int inputArrayIndex = 0;
        for(int i = min; i <= max; i++){
            while (counterArray[i - min] > 0){
                array[inputArrayIndex++] = i;
                counterArray[i - min] -= 1;
            }
        }
    }

    // Worst case O(n^2) , but it can perform much better than that
    public static void shellSort(int[] array) {
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

    public static void mergeSort(int[] array, int start, int end) {
        // if our sub array contains only 1 element, return
        if (end - start < 2) {
            return;
        }
        int i = start;
        int j = end;
        int middle = (i + j) / 2;
        mergeSort(array, i, middle);
        mergeSort(array, middle, end);
        merge(array, start, middle, end);
    }

    private static void merge(int[] array, int start, int middle, int end) {
        if (array[middle - 1] <= array[middle]) {
            return;
        }

        int i = start;
        int j = middle;
        int[] tempArray = new int[end - start];
        int tempIndex = 0;
        while(i < middle && j < end){
            tempArray[tempIndex++] = array[i] > array[j] ? array[j++] : array[i++];
        }

        System.arraycopy(array, i, array, start + tempIndex, middle - i);
        System.arraycopy(tempArray, 0, array, start, tempIndex);
    }

    // O(log n)
    public static void quickSort(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int j = partition(array, start, end);
        quickSort(array, start, j);
        quickSort(array, j + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && array[--j] > pivot) ;
            while (i < j && array[++i] < pivot) ;
            if (i < j) {
                // swap
                swap(i, j, array);
            }
        }
        // replace j element with the pivot (first position)
        swap(start, j, array);
        return j;
    }

    private static void swap(int firstPos, int secondPos, int[] array) {
        int temp = array[secondPos];
        array[secondPos] = array[firstPos];
        array[firstPos] = temp;
    }
}