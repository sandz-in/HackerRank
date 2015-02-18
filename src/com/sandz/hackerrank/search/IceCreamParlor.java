package com.sandz.hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class IceCreamParlor {
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
        int target = nextInt();
        int iceCreams = nextInt();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        boolean found = false;
        for (int i = 1; i <= iceCreams; i++) {
            int n = nextInt();
            int desiredNo = target - n;
            Integer position = map.get(desiredNo);
            if (!found && position != null) {
                System.out.println(position + " " + i);
                found = true;
            };
            if (map.get(n) == null) {
                map.put(n, i);
            }

        }

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
