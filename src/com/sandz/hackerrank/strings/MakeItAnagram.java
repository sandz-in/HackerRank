package com.sandz.hackerrank.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MakeItAnagram {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        String a = nextToken();
        String b = nextToken();
        Map<Character, Integer> aCount = new HashMap<Character, Integer>();
        // Map<Character, Integer> bCount = new HashMap<Character, Integer>();
        counter(a, aCount, true);
        counter(b, aCount, false);
        int counter = 0;
        for (Integer i : aCount.values()) {
            counter += Math.abs(i);
        }
        println(counter);
    }

    private void counter(String str, Map<Character, Integer> counter,
            boolean increment) {
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            Integer count = counter.get(x);
            if (count == null) {
                count = 0;
            }
            if (increment) {
                ++count;
            } else {
                --count;
            }
            counter.put(x, count);
        }
    }

    public static void main(String[] args) throws IOException {
        MakeItAnagram solution = new MakeItAnagram();
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
