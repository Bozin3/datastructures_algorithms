package com.bozin3.datastructuresalgorithms.algorithms;

public class Factorial {
    public static void basicFactorial(int num){
        if(num == 0){
            System.out.println(1);
            return;
        }

        int result = 1;
        for(int i = 1; i <= num; i++){
            result *= i;
        }
        System.out.println(result);
    }

    public static int recursiveFactorial(int num){
        if(num == 0){
            System.out.println(1);
            return 1;
        }

        int result = num--;
        result *= recursiveFactorial(num);

        System.out.println(result);
        return result;
    }
}
