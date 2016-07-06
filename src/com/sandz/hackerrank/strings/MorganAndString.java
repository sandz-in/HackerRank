package com.sandz.hackerrank.strings;
/**
 * Created by sandz on 11/5/15.
 * https://www.hackerrank.com/challenges/morgan-and-a-string
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MorganAndString {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int testCases = nextInt();
        while (testCases > 0) {
            String strA = nextToken();
            String strB = nextToken();
            StringBuffer buff = new StringBuffer();
            int i, j;
            for (i = 0, j = 0; i < strA.length() && j < strB.length(); ) {
                char c = strA.charAt(i);
                char d = strB.charAt(j);
                if (c < d) {
                    buff.append(c);
                    i++;
                } else if (c > d) {
                    buff.append(d);
                    j++;
                } else if (c == d) {
                    if (i + 1 < strA.length() && j + 1 < strB.length()) {
                        char c1 = strA.charAt(i + 1);
                        char d1 = strB.charAt(j + 1);
                        if (c1 <= d) {
                            buff.append(c);
                            i++;
                        } else if (c > d1) {
                            buff.append(d);
                            j++;
                        }
                    }
                }
            }

            if (i < strA.length()) {
                buff.append(strA.substring(i));
            }
            if (j < strB.length()) {
                buff.append(strB.substring(j));
            }
            println(buff);
            testCases--;
        }
    }

    public static void main(String[] args) throws IOException {
        MorganAndString solution = new MorganAndString();
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

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
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
