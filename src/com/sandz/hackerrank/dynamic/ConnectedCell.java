package com.sandz.hackerrank.dynamic;
/**
 * Created by sandz on 9/21/15.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ConnectedCell {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int m = nextInt();
        int n = nextInt();
        boolean[][] grid = new boolean[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = nextInt() == 1 ? true : false;
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    max = Math.max(count(grid, visited, i, j), max);
                }
            }
        }
        println(max);
    }

    private int count(boolean[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= visited.length || j >= visited[0].length)
            return 0;

        if (visited[i][j]) return 0;

        visited[i][j] = true;
        int r = 0;
        if (grid[i][j]) {
            r = 1;
        } else {
            return 0;
        }
        r += count(grid, visited, i - 1, j - 1);
        r += count(grid, visited, i - 1, j);
        r += count(grid, visited, i - 1, j + 1);
        r += count(grid, visited, i, j - 1);
        r += count(grid, visited, i, j + 1);
        r += count(grid, visited, i + 1, j - 1);
        r += count(grid, visited, i + 1, j);
        r += count(grid, visited, i + 1, j + 1);

        return r;
    }

    public static void main(String[] args) throws IOException {
        ConnectedCell solution = new ConnectedCell();
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

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
        } catch (Exception e) {}
        return st.nextToken();
    }
}

