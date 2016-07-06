package com.sandz.hackerrank.challenges.cloudera;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        long sum = 0;
        int retVal = -1;
        for (int i : A) {
            sum += i;
        }
        long tempSum = 0;
        for (int i = 0; i < A.length; i++) {
            if (sum - tempSum - A[i] == tempSum) {
                retVal = i;
                break;
            } else {
                tempSum += A[i];
            }
        }
        System.out.println(retVal);
        return retVal;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = { -1, 4, -4, 5, 1, -6, 3, 1 };
        solution.solution(A);
    }
}