/**
 * [SOLVED]
 * https://www.hackerrank.com/challenges/largest-permutation
 */

package com.sandz.hackerrank.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LargestPermutation {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    // TODO Needs optimization
    private void solve() throws IOException {
        int n = nextInt();
        int k = nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
        }
        for (int i = 0; i < n && k > 0; i++) {
            int temp = i;
            for (int j = i + 1; j < n; j++) {
                if (x[j] > x[temp]) {
                    temp = j;
                }
            }
            if (temp != i) {
                k--;
                x[i] += x[temp];
                x[temp] = x[i] - x[temp];
                x[i] = x[i] - x[temp];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(x[i] + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        LargestPermutation solution = new LargestPermutation();
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
