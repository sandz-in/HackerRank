package com.sandz.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaumAndBday {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        long testCases = nextLong();
        while (testCases-- > 0) {
            long b = nextLong();
            long w = nextLong();
            long x = nextLong();
            long y = nextLong();
            long z = nextLong();

            if (z + x < y) {
                y = z + x;
            }
            if (y + z < x) {
                x = y + z;
            }
            long sum = x * b + y * w;
            println(sum);
        }
    }

    public static void main(String[] args) throws IOException {
        TaumAndBday solution = new TaumAndBday();
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
