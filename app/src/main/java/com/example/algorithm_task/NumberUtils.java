package com.example.algorithm_task;

import java.util.HashSet;
import java.util.Set;

public class NumberUtils {

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) return false;
        }
        return true;
    }

    public static Set<Integer> getFibonacciNumbersUpTo(int limit) {
        Set<Integer> fibonacciNumbers = new HashSet<>();
        int a = 0, b = 1;
        while (a <= limit) {
            fibonacciNumbers.add(a);
            int next = a + b;
            a = b;
            b = next;
        }
        return fibonacciNumbers;
    }
}

