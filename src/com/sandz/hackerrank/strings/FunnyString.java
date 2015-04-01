package com.sandz.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FunnyString {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int t = nextInt();
        while (t-- > 0) {
            boolean err = false;
            String s = nextToken();
            int n = s.length();
            for (int i = 0, j = n - 1; i < n - 1; i++, j--) {
                if (Math.abs(s.charAt(i) - s.charAt(i + 1)) != Math.abs((s
                        .charAt(j) - s.charAt(j - 1)))) {
                    err = true;
                }
            }
            if (err)
                println("Not Funny");
            else
                println("Funny");
        }
    }
    public static void main(String[] args) throws IOException {
        FunnyString solution = new FunnyString();
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
