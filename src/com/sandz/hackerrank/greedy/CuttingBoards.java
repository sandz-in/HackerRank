/**
 * 
 * https://www.hackerrank.com/challenges/board-cutting
 */
package com.sandz.hackerrank.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CuttingBoards {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    int constant = (int) (Math.pow(10, 9) + 7);
    private void solve() throws IOException {
        int t = nextInt();
        while (t-- > 0) {
            int n = nextInt() - 1;
            int m = nextInt() - 1;
            long[] row = new long[n];
            long[] column = new long[m];
            long cost = 0;
            for (int i = 0; i < n; i++) {
                row[i] = nextInt();
            }
            for (int i = 0; i < m; i++) {
                column[i] = nextInt();
            }
            Arrays.sort(row);
            Arrays.sort(column);
            int j = n - 1, k = m - 1;
            int r = 0, c = 0;
            while (j >= 0 && k >= 0) {
                if (row[j] > column[k]) {
                    r++;
                    cost += (c + 1) * row[j--];
                    cost %= constant;
                } else {
                    c++;
                    cost += (r + 1) * column[k--];
                    cost %= constant;
                }
            }
            while (j >= 0) {
                cost += (c + 1) * row[j--];
                cost %= constant;
            }
            while (k >= 0) {
                cost += (r + 1) * column[k--];
                cost %= constant;
            }
            println(cost % constant);
        }
    }

    public static void main(String[] args) throws IOException {
        CuttingBoards solution = new CuttingBoards();
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
