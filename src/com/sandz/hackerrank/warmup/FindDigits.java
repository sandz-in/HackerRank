package com.sandz.hackerrank.warmup;

import java.util.Scanner;

public class FindDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long testCases = Long.parseLong(scanner.nextLine());
        for (int i = 0; i < testCases; i++) {
            solve(Long.parseLong(scanner.nextLine()));
        }
    }

    private static void solve(Long original) {
        long temp = original;
        int count = 0;
        while (temp > 0) {
            int remainder = (int) (temp % 10);
            if (remainder == 0) {
                temp = temp / 10;
                continue;
            }
            int rem = (int) (original % remainder);
            if (rem == 0)
                count++;
            temp = temp / 10;
        }

        System.out.println(count);
    }
}
