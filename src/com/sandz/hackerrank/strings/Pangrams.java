package com.sandz.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Pangrams {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        String token = br.readLine().toLowerCase();
        int counter = 0;
        boolean[] encountered = new boolean[26];
        for (int i = 0; i < token.length() && counter != 26; i++) {
            char c = token.charAt(i);
            int x = c - 'a';
            if (x > 25 || x < 0)
                continue;
            if (!encountered[x]) {
                counter++;
                encountered[x] = true;
            }
        }
        if (counter == 26)
            println("pangram");
        else
            println("not pangram");
    }

    public static void main(String[] args) throws IOException {
        Pangrams solution = new Pangrams();
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

}
