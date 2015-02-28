package com.sandz.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CommonChild {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        String s1 = nextToken();
        String s2 = nextToken();
        int length = s1.length();
        int length2 = s2.length();
        int[][] longest = new int[length + 1][length2 + 1];
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    longest[i][j] = 1 + longest[i - 1][j - 1];
                } else {
                    longest[i][j] = Math.max(longest[i - 1][j],
                            longest[i][j - 1]);
                }
            }
        }
        println(longest[length][length2]);
    }

    public static void main(String[] args) throws IOException {
        CommonChild solution = new CommonChild();
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
}
