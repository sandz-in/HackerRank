package com.sandz.hackerrank.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MaximumSubarray {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int testCases = nextInt();
        for (int i = 0; i < testCases; i++) {
            int size = nextInt();
            int a[] = new int[size];
            for (int x = 0; x < size; x++) {
                a[x] = nextInt();
            }
            int ans = findContiguousMaxSum(a);
            int ans2 = findNonContiguousMaxSum(a);
            println(ans + " " + ans2);
        }
    }

    private int findContiguousMaxSum(int[] a) {
        int bestSum = a[0];
        int currSum = bestSum;
        boolean whole = false;
        int maxNegative = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] >= 0) {
                whole = true;
            }
            if (a[i] > maxNegative) {
                maxNegative = a[i];
            }
            if (a[i] > 0 && currSum < 0) {
                currSum = a[i];
            } else {
                currSum += a[i];
            }
            if (currSum > bestSum) {
                bestSum = currSum;
            }
        }
        if (!whole) {
            return maxNegative;
        }

        return bestSum;
    }
    private int findNonContiguousMaxSum(int[] a) {
        int bestSum = a[0];
        boolean whole = false;
        int maxNegative = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] >= 0) {
                whole = true;
            }
            if (a[i] > maxNegative) {
                maxNegative = a[i];
            }
            if (bestSum <= 0 && a[i] > 0) {
                bestSum = a[i];
            } else if (bestSum + a[i] > (bestSum)) {
                bestSum += a[i];
            }
        }

        if (!whole) {
            return maxNegative;
        }

        return bestSum;
    }

    public static void main(String[] args) throws IOException {
        MaximumSubarray solution = new MaximumSubarray();
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
