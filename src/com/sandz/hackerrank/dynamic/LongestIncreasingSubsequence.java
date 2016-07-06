package com.sandz.hackerrank.dynamic;
/**
 * Created by sandz on 10/29/15.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LongestIncreasingSubsequence {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        nextDouble();
        nextInt();
        int n = nextInt();
        for (int i = 0; i < n; i++) {

        }
        int lis[] = new int[n];
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            lis[i] = 1;

   /* Compute optimized LIS values in bottom up manner */
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

   /* Pick maximum of all LIS values */
        int max = 0;
        for (int i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];
        nextLong();
        println("");
    }

    public static void main(String[] args) throws IOException {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        try {
            solution.initialize();
            solution.solve();
        } finally {
            solution.close();
        }
    }

    private void close() throws IOException {
        br.close();
        out.close();
    }

    private void initialize() {
        InputStream input = System.in;
        br = new BufferedReader(new InputStreamReader(input));
        PrintStream output = System.out;
        out = new PrintWriter(output);
    }

    private void println(Object o) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(o);
        stringBuilder.append("\n");
        out.write(stringBuilder.toString());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private String nextToken() throws IOException {
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