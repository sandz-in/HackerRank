/**
 * [SOLVED]
 * https://www.hackerrank.com/challenges/jim-and-the-orders
 */
package com.sandz.hackerrank.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JimAndTheOrders {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;
    public class Pair implements Comparable<Pair> {
        public final int index;
        public final long value;

        public Pair(int index, long value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair other) {
            return Long.valueOf(this.value).compareTo(other.value);
        }
    }
    private void solve() throws IOException {
        int n = nextInt();
        Pair t[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            t[i] = new Pair(i + 1, nextLong() + nextLong());
        }
        Arrays.sort(t);
        for (int i = 0; i < n; i++) {
            System.out.print(t[i].index + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        JimAndTheOrders solution = new JimAndTheOrders();
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

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
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
