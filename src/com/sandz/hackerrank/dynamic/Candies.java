package com.sandz.hackerrank.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Candies {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int size = nextInt();
        int students[] = new int[size];
        for (int i = 0; i < size; i++) {
            students[i] = nextInt();
        }
        int candies[] = new int[size];
        Arrays.fill(candies, 1);
        for (int i = 0; i < size - 1; i++) {
            if (students[i] < students[i + 1]) {
                candies[i + 1] = candies[i] + 1;
            }
        }

        for (int i = size - 1; i > 0; i--) {
            if (students[i - 1] > students[i])
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += candies[i];
        }
        println(sum);
    }

    public static void main(String[] args) throws IOException {
        Candies solution = new Candies();
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
