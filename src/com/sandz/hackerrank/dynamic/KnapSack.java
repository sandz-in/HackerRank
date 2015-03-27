package com.sandz.hackerrank.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KnapSack {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int testCases = nextInt();
        while (testCases-- > 0) {
            int n = nextInt();
            int W = nextInt();
            int[] w = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                w[i] = nextInt();
            }
            boolean[] vis = new boolean[W + 1];
            vis[0] = true;
            int max = 0;
            for (int j = 0; j <= W; j++) {
                for (int i = 0; i <= n; i++) {
                    if (i == 0 || j == 0) {
                    } else if ((j - w[i]) >= 0) {
                        vis[j] = vis[j] || vis[j - w[i]];
                        if (vis[j]) {
                            max = j;
                            continue;
                        }
                    }
                }
            }
            println(max);
        }
    }

    public static void main(String[] args) throws IOException {
        KnapSack solution = new KnapSack();
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
