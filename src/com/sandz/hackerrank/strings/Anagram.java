package com.sandz.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Anagram {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void processInputAndSolve() throws IOException {
        int no = nextInt();
        for (int i = 0; i < no; i++) {
            String string = nextToken();
            int answer = solve(string);
            println(answer);
        }
    }

    private int solve(String string) {
        int retVal = 0;
        if (string.length() % 2 == 1) {
            return -1;
        }
        String s1 = string.substring(0, string.length() / 2);
        String s2 = string.substring(string.length() / 2, string.length());
        int[] s1C = countCharacters(s1);
        int[] s2C = countCharacters(s2);
        for (int i = 0; i < s1C.length; i++) {
            retVal += Math.abs(s1C[i] - s2C[i]);
        }
        return retVal / 2;
    }

    private int[] countCharacters(String s1) {
        int[] retVal = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            int pos = s1.charAt(i) - 'a';
            retVal[pos]++;
        }
        return retVal;
    }

    public static void main(String[] args) throws IOException {
        Anagram solution = new Anagram();
        try {
            solution.initialize();
            solution.processInputAndSolve();
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
