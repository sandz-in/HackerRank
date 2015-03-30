/**
 * [SOLVED]
 * https://www.hackerrank.com/challenges/grid-challenge
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

public class GridChallenge {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int testCases = nextInt();
        while (testCases-- > 0) {
            int size = nextInt();
            char[][] grid = new char[size][size];
            boolean matching = true;
            for (int i = 0; i < size; i++) {
                char[] arr = nextToken().toCharArray();
                if (matching)
                    Arrays.sort(arr);
                grid[i] = arr;
                if (i == 0) {
                    continue;
                }
                if (matching) {
                    for (int j = 0; j < size; j++) {
                        if (grid[i][j] < grid[i - 1][j]) {
                            matching = false;
                            break;
                        }
                    }
                }
            }
            if (!matching) {
                println("NO");
            } else {
                println("YES");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        GridChallenge solution = new GridChallenge();
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
