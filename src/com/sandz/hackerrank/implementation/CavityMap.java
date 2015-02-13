package com.sandz.hackerrank.implementation;

import java.util.Scanner;

public class CavityMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());
        int[][] room = new int[n][n];
        for (int i = 0; i < n; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                room[i][j] = Integer.parseInt(row.charAt(j) + "");
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int candidate = room[i][j];
                if (i > 0 && j > 0 && j < n - 1 && i < n - 1
                        && candidate > room[i - 1][j]
                        && candidate > room[i][j - 1]
                        && candidate > room[i][j + 1]
                        && candidate > room[i + 1][j]) {
                    System.out.print("X");
                } else {
                    System.out.print(candidate);
                }
            }
            System.out.println();
        }
    }
}
