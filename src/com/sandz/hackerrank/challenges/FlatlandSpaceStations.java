package com.sandz.hackerrank.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/contests/worldcodesprint/challenges/powerplants-in
 * -flatland
 * 
 * @author sandz
 *
 */
public class FlatlandSpaceStations {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        int a[] = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = nextInt();
        }
        Arrays.sort(a);
        int max = Math.max(a[0], n - 1 - a[m - 1]);
        for (int i = 1; i < a.length; i++) {
            int diff = (a[i] - a[i - 1]) / 2;
            max = Math.max(max, diff);
        }
        println(max);
    }

    public static void main(String[] args) throws IOException {
        FlatlandSpaceStations solution = new FlatlandSpaceStations();
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
