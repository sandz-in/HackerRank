package com.sandz.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SegmentTreeSum {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;
    int[] s;

    private void solve() throws IOException {
        int n = nextInt();
        int[] a = nextIntArray(n);
        int stlength = 2 * (int) Math.pow(2, (Math.ceil(Math.log(n) / Math.log(2)))) - 1;
        s = new int[stlength];
        segment(0, n - 1, 0, a);
        System.out.println(getSum(0, n - 1, 3, 4, 0));
    }

    int getSum(int ss, int se, int qs, int qe, int si) {
        if (qs <= ss && qe >= se) {
            return s[si];
        }
        if (se < qs || ss > qe) {
            return 0;
        }
        int mid = (ss) + (se - ss) / 2;
        return getSum(ss, mid, qs, qe, si * 2 + 1) + getSum(mid + 1, se, qs, qe, si * 2 + 2);
    }

    int segment(int ss, int se, int si, int[] a) {
        if (ss == se) {
            s[si] = a[ss];
            return a[ss];
        }
        int mid = (ss) + (se - ss) / 2;
        s[si] = segment(ss, mid, si * 2 + 1, a) + segment(mid + 1, se, si * 2 + 2, a);
        return s[si];
    }

    public static void main(String[] args) throws IOException {
        SegmentTreeSum solution = new SegmentTreeSum();
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

    private int[] nextIntArray(int n) throws IOException {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        return a;
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
