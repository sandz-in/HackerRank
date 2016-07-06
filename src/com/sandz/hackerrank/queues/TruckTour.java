package com.sandz.hackerrank.queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TruckTour {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int n = nextInt();
        int[] pump = new int[n];
        int[] dist = new int[n];
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            pump[i] = nextInt();
            dist[i] = nextInt();
            diff[i] = pump[i] - dist[i];
        }
        int dest = -1;
        int remaining = 0;

        for (int i = 0; i < n; i++) {
            if (remaining + diff[i] >= 0) {
                if (dest == -1) {
                    dest = i;
                }
                remaining += diff[i];
            } else {
                remaining = 0;
                dest = -1;
            }
        }
        println(dest);

    }

    public static void main(String[] args) throws IOException {
        TruckTour solution = new TruckTour();
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
