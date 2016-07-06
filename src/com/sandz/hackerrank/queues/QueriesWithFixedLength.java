package com.sandz.hackerrank.queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class QueriesWithFixedLength {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int n = nextInt();
        int q = nextInt();
        int[] seq = new int[n];
        int[] queries = new int[q];
        for (int i = 0; i < n; i++) {
            seq[i] = nextInt();
        }
        for (int i = 0; i < q; i++) {
            queries[i] = nextInt();
        }
        Deque<Integer> dq = new LinkedList<Integer>();
        for (int i = 0; i < queries.length; i++) {
            int qsize = queries[i];
            int j = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            while (dq.size() < qsize) {
                max = Math.max(max, seq[j]);
                dq.add(seq[j++]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        QueriesWithFixedLength solution = new QueriesWithFixedLength();
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
