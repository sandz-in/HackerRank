package com.sandz.hackerrank.airwatch;
/**
 * https://www.hackerrank.com/contests/airwatch-nc-state/challenges/xrange-subsets
 * Created by sandz on 10/13/15.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class XrangeAndSubsets {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int testCases = nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = nextInt();
            int k = nextInt();
            int min = n / k;
            int max = n % k;
            int low = k - max;
            int count = 0;
            if (low > 0) {
                count += (min * (min - 1) / 2) * (low);
            }
            if (max > 0) {
                count += ((min + 1) * (min) / 2) * max;
            }
            println(count);
        }
    }

    public static void main(String[] args) throws IOException {
        XrangeAndSubsets solution = new XrangeAndSubsets();
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
