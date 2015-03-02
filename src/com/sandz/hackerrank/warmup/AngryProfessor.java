package com.sandz.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AngryProfessor {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int testCases = nextInt();
        while (testCases-- > 0) {
            int counter = 0;
            int students = nextInt();
            int threshold = nextInt();
            for (int i = 0; i < students; i++) {
                int j = nextInt();
                if (j <= 0) {
                    counter++;
                }
            }
            if (counter >= threshold) {
                println("NO");
            } else {
                println("YES");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        AngryProfessor solution = new AngryProfessor();
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
