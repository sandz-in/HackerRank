package com.sandz.hackerrank.challenges.cloudera;

//you can also use imports, for example:
import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution1 {
    public int solution(int[] A, int[] B) {
        Set<Integer> aset = new HashSet<Integer>();
        for (int i : A) {
            aset.add(i);
        }
        int min = Integer.MAX_VALUE;
        boolean found = false;
        for (int i = 0; i < B.length; i++) {
            if (B[i] < min && aset.contains(B[i])) {
                min = B[i];
                found = true;
            }
        }

        if (found) {
            return min;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] B = { 5, 3, 8, 3 };
        int[] A = { 1, 6, 2, 9, 4 };
        int a = solution1.solution(A, B);
        System.out.println(a);
    }
}