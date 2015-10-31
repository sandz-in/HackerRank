package com.sandz.hackerrank.airwatch;
/**
 * https://www.hackerrank.com/contests/airwatch-nc-state/challenges/toy-blocks
 * Created by sandz on 10/13/15.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ToyBlocks {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    long count(int S[], int coin) {
        int m = S.length;
        long x, y;
        int j, i;

        long table[][] = new long[coin + 1][m];

        for (i = 0; i < m; i++)
            table[0][i] = 1;
        long mod = (long) Math.pow(10, 9) + 7;

        for (i = 1; i < coin + 1; i++) {
            for (j = 0; j < m; j++) {
                x = (i - S[j] >= 0) ? table[i - S[j]][j] : 0;
                y = (j >= 1) ? table[i][j - 1] : 0;

                table[i][j] = (x + y) % mod;
            }
        }
        return table[coin][m - 1];
    }

    int anotherSolution(int[] s, int m) {
        int n = s.length;
        int table[] = new int[n + 1];
        table[0] = 1;
        for (int i = 0; i < m; i++)
            for (int j = s[i]; j <= n; j++)
                table[j] += table[j - s[i]];

        return table[n];
    }

    private void solve() throws IOException {
        int n = nextInt();
        int s[] = new int[n];
        for (int i = 2; i <= s.length; i++) {
            s[i - 2] = i;
        }
        long ans = count(s, n);
        long mod = (long) Math.pow(10, 9) + 7;
        ans = ans % mod;
        println((long) (ans % (mod)));
    }

    public static void main(String[] args) throws IOException {
        ToyBlocks solution = new ToyBlocks();
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

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
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
