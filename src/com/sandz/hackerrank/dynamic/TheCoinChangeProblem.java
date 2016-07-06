package com.sandz.hackerrank.dynamic;
/**
 * Created by sandz on 9/23/15.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheCoinChangeProblem {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        int[] denominations = new int[m];
        for (int i = 0; i < m; i++) {
            denominations[i] = nextInt();
        }

        Arrays.sort(denominations);
        int[] change = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (i >= denominations[j]) {
                    if (i - denominations[j] == 0) {
                        change[i] += 1;
                    } else if ((i - denominations[j]) >= denominations[j]) {
                        change[i] += change[i - denominations[j]];
                    }
                }
            }
            out.println(i + " " + change[i]);
        }
        out.println(change[n]);
    }

    public static void main(String[] args) throws IOException {
        TheCoinChangeProblem solution = new TheCoinChangeProblem();
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