package com.sandz.hackerrank.datastructures.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SparseArrays {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int n = nextInt();
        Map<String, Integer> strings = new HashMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            String x = nextToken();
            Integer counter = strings.get(x);
            if (counter == null) {
                counter = 0;
            }
            strings.put(x, ++counter);
        }
        int q = nextInt();
        for (int i = 0; i < q; i++) {
            String query = nextToken();
            Integer counter = strings.get(query);
            if (counter == null) {
                counter = 0;
            }
            println(counter);
        }
    }

    public static void main(String[] args) throws IOException {
        SparseArrays solution = new SparseArrays();
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
