package com.sandz.hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Pairs {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int n = nextInt();
        int k = nextInt();
        int count = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            Integer key = nextInt();
            set.add(key);
        }
        for (int i : set) {
            int target = i - k;
            if (target != i && set.contains(target)) {
                count++;
            }
        }

        printWithNewLine(count);
    }

    public static void main(String[] args) throws IOException {
        Pairs solution = new Pairs();
        solution.initialize();
        solution.solve();
        solution.close();
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

    private void printWithNewLine(Object o) {
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
