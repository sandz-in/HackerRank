package com.sandz.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SherlockAndSquares {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int testCases = nextInt();
        while (testCases-- > 0) {
            int a = nextInt();
            int b = nextInt();
            int sqrt = (int) Math.sqrt(a);

            if (((int) Math.pow(sqrt, 2)) != a)
                a = (sqrt + 1);
            else
                a = sqrt;
            b = (int) Math.sqrt(b);
            println(b - a + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        SherlockAndSquares solution = new SherlockAndSquares();
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
