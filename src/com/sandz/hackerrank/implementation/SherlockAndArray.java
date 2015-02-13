package com.sandz.hackerrank.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SherlockAndArray {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    private static void solve() throws IOException {
        int testCases = nextInt();
        for (int i = 0; i < testCases; i++) {
            int arrsize = nextInt();
            long[] arr = new long[arrsize];
            for (int j = 0; j < arrsize; j++) {
                arr[j] = nextLong();
            }
            solve(arr);
        }
    }

    private static void solve(long[] arr) {
        long leftSum = 0, rightSum = 0;
        int x = 0;
        int y = arr.length - 1;
        while (x < y) {
            if (leftSum == rightSum) {
                leftSum += arr[x];
                rightSum += arr[y];
                x++;
                y--;
            } else if (leftSum > rightSum) {
                rightSum += arr[y];
                y--;
            } else if (rightSum > leftSum) {
                leftSum += arr[x];
                x++;
            }
        }
        if (x == y && leftSum == rightSum) {
            out.write("YES\n");
        } else {
            out.write("NO\n");
        }
    }

    public static void main(String[] args) throws IOException {
        InputStream input = System.in;
        PrintStream output = System.out;
        br = new BufferedReader(new InputStreamReader(input));
        out = new PrintWriter(output);
        solve();
        br.close();
        out.close();
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }
}
