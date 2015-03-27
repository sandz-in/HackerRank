package com.sandz.hackerrank.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LongestCommonSubsequence {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = nextInt();
        }
        String[][] longest = new String[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    longest[i][j] = "";
                    continue;
                }
                if (a[i - 1] == b[j - 1]) {
                    longest[i][j] = longest[i - 1][j - 1] + " " + a[i - 1];
                } else {
                    if (longest[i - 1][j].length() > longest[i][j - 1].length()) {
                        longest[i][j] = longest[i - 1][j];
                    } else {
                        longest[i][j] = longest[i][j - 1];
                    }
                }
            }
        }
        println(longest[n][m].trim());
    }
    public static void main(String[] args) throws IOException {
        LongestCommonSubsequence solution = new LongestCommonSubsequence();
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

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
}
