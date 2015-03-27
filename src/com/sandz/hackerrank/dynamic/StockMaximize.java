package com.sandz.hackerrank.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StockMaximize {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int testCases = nextInt();
        for (int i = 0; i < testCases; i++) {
            int days = nextInt();
            int[] prices = new int[days];
            for (int j = 0; j < days; j++) {
                prices[j] = nextInt();
            }
            long profit = 0;
            int mx = prices[days - 1];
            for (int j = days - 1; j >= 0; j--) {
                int stock = prices[j];
                if (stock < mx) {
                    profit += (mx - stock);
                } else {
                    mx = stock;
                }
            }
            println(profit);
        }
    }
    public static void main(String[] args) throws IOException {
        StockMaximize solution = new StockMaximize();
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
