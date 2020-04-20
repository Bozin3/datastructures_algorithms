package com.bozin3.datastructuresalgorithms.algorithms;

public class SearchAlgorithms {

    // O(n)
    public static int linearSearch(int[] inputArray, int value){

        for(int x = 0; x < inputArray.length; x++){
            if(inputArray[x] == value){
                return x;
            }
        }

        return -1;
    }

    // O(log n)
    public static int iterativeBinarySearch(int[] inputArray, int value){

        int start = 0;
        int end = inputArray.length;

        while (start < end){
            int mid = (end + start) / 2;
            if(inputArray[mid] == value){
                return mid;
            }else if(inputArray[mid] > value){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return -1;
    }

    // O(log n)
    public static int recursiveBinarySearch(int[] inputArray, int start, int end, int value){

        if(start < end){
            int mid = (end + start) / 2;
            if(inputArray[mid] == value){
                return mid;
            }else if(inputArray[mid] > value){
                return recursiveBinarySearch(inputArray,start,mid,value);
            }else{
                return recursiveBinarySearch(inputArray, mid+1, end, value);
            }
        }

        return -1;
    }
}
