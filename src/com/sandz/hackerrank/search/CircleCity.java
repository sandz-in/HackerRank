package com.sandz.hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CircleCity {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args) throws IOException {
        InputStream input = System.in;
        PrintStream output = System.out;
        br = new BufferedReader(new InputStreamReader(input));
        out = new PrintWriter(output);
        processInputAndSolve();
        br.close();
        out.close();
    }

    private static void processInputAndSolve() throws IOException {
        int testCases = nextInt();
        for (int i = 0; i < testCases; i++) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int rSquare = nextInt();
        int policeStation = nextInt();
        int count = 0;
        float radius = (float) Math.sqrt(rSquare);
        for (int i = 0; i < radius; i++) {
            double y = rSquare - Math.pow(i, 2);
            int j = (int) Math.sqrt(y);
            if ((j * j) == y)
                count++;
        }
        out.write(policeStation < (count * 4) ? "impossible\n" : "possible\n");
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static String nextToken() throws IOException {
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
