package com.sandz.hackerrank.airwatch;

/**
 * https://www.hackerrank.com/contests/airwatch-nc-state/challenges/tyrion-and-wine
 * Created by sandz on 10/13/15.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class TyrionAndWine {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        long n = nextLong();
        long k = nextLong();
        Queue<Long> q = new PriorityQueue<Long>();
        for (int i = 0; i < n; i++) {
            q.add(nextLong());
        }
        boolean found = false;
        long operations = 0;
        while (!q.isEmpty()) {
            long a = q.poll();

            if (a < k) {
                if (q.size() > 0) {
                    long b = q.poll();
                    operations++;
                    long newVal = a + (2 * b);
                    q.add(newVal);
                }
            } else {
                found = true;
                break;
            }
        }

//        if (n == 1) {
//            if (!q.isEmpty()) {
//                long x = q.poll();
//                if (x >= k)
//                    found = true;
//            }
//        }
        if (found)
            println(operations);
        else
            println(-1);
    }

    public static void main(String[] args) throws IOException {
        TyrionAndWine solution = new TyrionAndWine();
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
