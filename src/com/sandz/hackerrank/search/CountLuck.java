package com.sandz.hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CountLuck {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;
    int K = 0;
    private void processInputAndSolve() throws IOException {
        int testCases = nextInt();
        for (int i = 0; i < testCases; i++) {
            int row = nextInt();
            int column = nextInt();
            char[][] matrix = new char[row][column];
            boolean[][] visited = new boolean[row][column];
            int start_x = 0, start_y = 0;
            for (int j = 0; j < row; j++) {
                String rows = nextToken();
                for (int k = 0; k < rows.length(); k++) {
                    char cell = rows.charAt(k);
                    if (cell == 'M') {
                        start_x = j;
                        start_y = k;
                    }
                    if (cell == 'X') {
                        visited[j][k] = true;
                    }
                    matrix[j][k] = cell;
                }
            }
            K = nextInt();
            int k = 0;
            printWithNewLine(solve(matrix, visited, start_x, start_y, k)
                    ? "Impressed"
                    : "Oops!");
        }
    }

    private boolean solve(char[][] matrix, boolean[][] visited, int x, int y,
            int k) {
        int count = 0;
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length
                || visited[x][y]) {
            return false;
        }
        if (matrix[x][y] == '*') {
            if (k == K) {
                return true;
            }
        }
        if (x - 1 >= 0 && !visited[x - 1][y]) {
            count++;
        }
        if (y - 1 >= 0 && !visited[x][y - 1]) {
            count++;
        }

        if (x + 1 < matrix.length && !visited[x + 1][y]) {
            count++;
        }
        if (y + 1 < matrix[0].length && !visited[x][y + 1]) {
            count++;
        }
        int wandUse = k + (count > 1 ? 1 : 0);
        if (!visited[x][y]) {
            visited[x][y] = true;
            boolean retVal = false;
            retVal = solve(matrix, visited, x + 1, y, wandUse);
            if (retVal)
                return true;

            retVal = solve(matrix, visited, x - 1, y, wandUse);
            if (retVal)
                return true;

            retVal = solve(matrix, visited, x, y + 1, wandUse);
            if (retVal)
                return true;
            retVal = solve(matrix, visited, x, y - 1, wandUse);
            if (retVal)
                return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        CountLuck solution = new CountLuck();
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
