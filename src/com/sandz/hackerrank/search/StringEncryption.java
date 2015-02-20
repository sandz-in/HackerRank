package com.sandz.hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StringEncryption {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    public static void main(String[] args) throws IOException {
        StringEncryption solution = new StringEncryption();
        solution.initialize();
        solution.solve();
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

    private void solve() throws IOException {
        String word = nextToken();
        int length = word.length();
        float sqrt = (float) Math.sqrt(length);
        int column = (int) Math.ceil(sqrt);
        int row = (int) Math.floor(sqrt);
        if (row * column < length)
            row++;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                int index = i + (j * column);
                if (index >= length)
                    break;
                System.out.print(word.charAt(index));
            }
            System.out.print(" ");
        }
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
