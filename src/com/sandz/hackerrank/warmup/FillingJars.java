package com.sandz.hackerrank.warmup;

import java.util.Scanner;

public class FillingJars {
    static long sum = 0l;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nm = in.nextLine();
        String[] nms = nm.split(" ");
        long n = Long.parseLong(nms[0]);
        long m = Long.parseLong(nms[1]);
        for (long i = 0; i < m; i++) {
            solve(in.nextLine());
        }
        in.close();

        System.out.println((long) Math.ceil(sum / n));
    }
    private static void solve(String string) {
        String[] operations = string.split(" ");
        long a = Long.parseLong(operations[0]);
        long b = Long.parseLong(operations[1]);
        long c = Long.parseLong(operations[2]);
        sum += (b - a + 1) * c;

    }
}
