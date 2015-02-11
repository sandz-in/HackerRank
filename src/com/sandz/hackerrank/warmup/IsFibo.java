package com.sandz.hackerrank.warmup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IsFibo {
    static List<Long> fibbo = new ArrayList<Long>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        fibbo.add(0l);
        fibbo.add(1l);
        int i = 1;
        double pow = Math.pow(10, 10);
        while (true) {
            long nextFibbo = fibbo.get(i) + fibbo.get(i - 1);
            if (nextFibbo > pow)
                break;
            fibbo.add(nextFibbo);
            i++;
        }
        long testCases = Long.parseLong(scanner.nextLine());
        for (i = 0; i < testCases; i++) {
            long testNumber = Long.parseLong(scanner.nextLine());
            Integer x = Collections.binarySearch(fibbo, testNumber);
            if (x != null && x >= 0) {
                System.out.println("IsFibo");
            } else {
                System.out.println("IsNotFibo");
            }
        }

    }
}
