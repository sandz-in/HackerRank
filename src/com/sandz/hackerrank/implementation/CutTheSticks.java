package com.sandz.hackerrank.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class CutTheSticks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfSticks = Integer.parseInt(scanner.nextLine());
        String sticksStr = scanner.nextLine();
        String[] sticksStrArr = sticksStr.split(" ");
        int[] sticks = new int[noOfSticks];
        for (int i = 0; i < noOfSticks; i++) {
            sticks[i] = Integer.parseInt(sticksStrArr[i]);
        }

        Arrays.sort(sticks);
        solve(sticks);
    }

    private static void solve(int[] sticks) {
        int size = sticks.length;
        for (int i = 0; i < size;) {
            int j = i;
            while (j < size && sticks[i] == sticks[j]) {
                j++;
            }
            System.out.println(size - i);
            i = j;
        }
    }
}
