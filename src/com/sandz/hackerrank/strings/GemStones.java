package com.sandz.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GemStones {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int noOfStones = nextInt();
        int count = 0;
        String[] rocks = new String[noOfStones];
        for (int i = 0; i < rocks.length; i++) {
            rocks[i] = nextToken();
        }
        boolean[] visited = new boolean[26];
        Arrays.fill(visited, true);
        for (int i = 0; i < rocks.length; i++) {
            boolean[] temp = new boolean[26];
            String string = rocks[i];
            for (int j = 0; j < string.length(); j++) {
                temp[string.charAt(j) - 'a'] = true;
            }
            updateVisited(visited, temp);
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i])
                count++;
        }
        println(count);
    }

    private void updateVisited(boolean[] visited, boolean[] temp) {
        for (int i = 0; i < visited.length; i++) {
            visited[i] &= temp[i];
        }
    }

    public static void main(String[] args) throws IOException {
        GemStones solution = new GemStones();
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
