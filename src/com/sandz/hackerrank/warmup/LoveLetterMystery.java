package com.sandz.hackerrank.warmup;

import java.io.IOException;
import java.util.Scanner;

public class LoveLetterMystery {
    public static void main(String[] args) throws NumberFormatException,
            IOException {
        Scanner in = new Scanner((System.in));
        int testCases = Integer.parseInt(in.nextLine());

        String[] patterns = new String[testCases];
        for (int i = 0; i < testCases; i++) {
            patterns[i] = in.nextLine();
        }
        in.close();
        // Long start = System.currentTimeMillis();

        for (int i = 0; i < testCases; i++) {
            System.out.println(solve(patterns[i]));
        }
        // Long end = System.currentTimeMillis();
        // System.out.println((end - start));
    }

    private static Integer solve(String pattern) {
        int retVal = 0;
        int length = pattern.length();
        for (int i = 0; i < (length / 2); i++) {
            retVal += Math.abs(pattern.charAt(i)
                    - pattern.charAt(length - 1 - i));
        }
        return retVal;
    }
}
