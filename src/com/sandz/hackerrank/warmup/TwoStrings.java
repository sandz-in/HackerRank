package com.sandz.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class TwoStrings {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int testCases = nextInt();
        while (testCases-- > 0) {
            Set<Character> a = new HashSet<Character>();
            Set<Character> b = new HashSet<Character>();
            stringToSet(a);
            stringToSet(b);
            a.retainAll(b);
            if (a.size() > 0) {
                println("YES");
            } else {
                println("NO");
            }
        }
    }
    private void stringToSet(Set<Character> a) throws IOException {
        String s = nextToken();
        for (int i = 0; i < s.length(); i++) {
            a.add(s.charAt(i));
        }
    }

    public static void main(String[] args) throws IOException {
        TwoStrings solution = new TwoStrings();
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
