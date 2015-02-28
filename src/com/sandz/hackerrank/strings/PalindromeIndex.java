package com.sandz.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PalindromeIndex {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void processInputAndSolve() throws IOException {
        int no = nextInt();
        for (int i = 0; i < no; i++) {
            String st = nextToken();
            int c = solve(st);
            println(c);
        }
    }

    private boolean isPalindrome(String st) {
        int i = 0;
        int j = st.length() - 1;
        while (i < j) {
            if (st.charAt(i) != st.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    private int solve(String st) {
        int retVal = -1;
        int i = 0;
        int j = st.length() - 1;
        while (i < j) {
            if (st.charAt(i) == st.charAt(j)) {
                i++;
                j--;
            } else {
                if (isPalindrome(st.substring(i, j)))
                    return j;
                return i;
            }
        }
        return retVal;
    }
    public static void main(String[] args) throws IOException {
        PalindromeIndex solution = new PalindromeIndex();
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
