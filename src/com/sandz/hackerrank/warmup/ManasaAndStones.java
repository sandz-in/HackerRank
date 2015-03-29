package com.sandz.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ManasaAndStones {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int testCases = nextInt();
        while (testCases-- > 0) {
            int n = nextInt();
            int a = nextInt(), b = nextInt();
            if (a > b) {
                a += b;
                b = a - b;
                a = a - b;
            }
            int lowerBound = a * (n - 1);
            int upperBound = b * (n - 1);
            int diff = b - a;
            if (diff == 0) {
                System.out.println(lowerBound);
                continue;
            }

            while (lowerBound <= upperBound) {
                System.out.print(lowerBound + " ");
                lowerBound += diff;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        ManasaAndStones solution = new ManasaAndStones();
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
