package com.sandz.hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GridSearch {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;
    public int globalIndex;

    @SuppressWarnings("unused")
    private void processInputAndSolve() throws IOException {
        int testCases = nextInt();
        for (int i = 0; i < testCases; i++) {
            int row = nextInt();
            int column = nextInt();
            String[] grid = new String[row];
            for (int x = 0; x < row; x++) {
                grid[x] = nextToken();
            }

            int patternRow = nextInt();
            int patternColummn = nextInt();
            String[] pattern = new String[patternRow];
            for (int x = 0; x < patternRow; x++) {
                pattern[x] = nextToken();
            }
            globalIndex = -1;
            solve(grid, pattern);
            if (globalIndex != -1) {
                printWithNewLine("YES");
            } else {
                printWithNewLine("NO");
            }
        }
    }

    private void solve(String[] grid, String[] pattern) {
        int j = 0;
        for (int i = 0; i < grid.length && j < pattern.length; i++) {
            String row = grid[i];
            String sub = pattern[j];
            int index = row.indexOf(sub);
            if (globalIndex == -1) {
                globalIndex = index;
            }
            if (index != -1 && globalIndex == index) {
                j++;
            } else {
                j = 0;
                globalIndex = -1;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        GridSearch solution = new GridSearch();
        solution.initialize();
        solution.processInputAndSolve();
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
