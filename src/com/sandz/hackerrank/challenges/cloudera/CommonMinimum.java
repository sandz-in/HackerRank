package com.sandz.hackerrank.challenges.cloudera;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CommonMinimum {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int n = nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        int m = nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = nextInt();
        }

        Set<Integer> aa = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            aa.add(a[i]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (aa.contains(b[i]) && b[i] < min) {
                min = b[i];
            }
        }

        System.out.println(min);

    }

    public static void main(String[] args) throws IOException {
        CommonMinimum solution = new CommonMinimum();
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
