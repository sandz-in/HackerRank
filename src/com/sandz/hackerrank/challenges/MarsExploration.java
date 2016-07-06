package com.sandz.hackerrank.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/contests/worldcodesprint/challenges/save-our-ship
 * 
 * @author sandz
 *
 */
public class MarsExploration {

    public BufferedReader br;
    public StringTokenizer st;

    private void solve() throws IOException {
        String s = nextToken();
        int count = 0;
        String sos = "SOS";
        for (int i = 0, j = 0; i < s.length(); i++, j++, j %= 3) {
            if (s.charAt(i) != sos.charAt(j)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        MarsExploration solution = new MarsExploration();
        try {
            solution.initialize();
            solution.solve();
        } finally {
            solution.close();
        }
    }

    private void close() throws IOException {
        br.close();
    }

    private void initialize() {
        InputStream input = System.in;
        br = new BufferedReader(new InputStreamReader(input));
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
