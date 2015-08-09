package com.sandz.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PlusMinus {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int n = nextInt();
        int a[] = new int[n];
        int nzero = 0, npos = 0, nneg = 0;
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            if (a[i] == 0)
                nzero++;
            if (a[i] > 0)
                npos++;
            if (a[i] < 0)
                nneg++;
        }
        println(((float) npos / n));
        println(((float) nneg / n));
        println(((float) nzero / n));
    }

    public static void main(String[] args) throws IOException {
        PlusMinus solution = new PlusMinus();
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
