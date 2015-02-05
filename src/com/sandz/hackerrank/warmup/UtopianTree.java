package com.sandz.hackerrank.warmup;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UtopianTree {
    static Map<Integer, Integer> sol = new HashMap<Integer, Integer>();
    static void solve(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int x = a[i];
            System.out.println(findSolution(x));
        }
    }

    private static Integer findSolution(int x) {
        Integer retVal = sol.get(x);
        if (retVal == null) {
            retVal = findSolution(x - 1);
            if (x % 2 == 1) {
                retVal = retVal * 2;
            } else {
                retVal += 1;
            }

            sol.put(x, retVal);
        }

        return retVal;
    }
    public static void main(String[] args) {
        sol.put(0, 1);
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine().trim());
        int a[] = new int[testCases];
        for (int i = 0; i < testCases; i++) {
            a[i] = Integer.parseInt(in.nextLine());
        }

        solve(a);

    }

}
