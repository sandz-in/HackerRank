package com.sandz.hackerrank.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RedJohnIsBack {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int testCase = nextInt();
        while (testCase-- > 0) {
            int N = nextInt();
            int solution[] = new int[N + 1];
            Arrays.fill(solution, 1);
            for (int i = 4; i <= N; i++) {
                solution[i] = solution[i - 1] + solution[i - 4];
            }
            println(findNoOfPrime(solution[N]));
        }
    }

    private int findNoOfPrime(int combinations) {
        int noOfPrimes = 0;
        for (int i = 2; i <= combinations; i++) {
            int factors = 0;
            int x = (int) Math.sqrt(i);
            for (int j = 2; j <= x; j++) {
                if (i % j == 0)
                    factors++;
            }
            if (factors == 0)
                noOfPrimes++;
        }
        return noOfPrimes;
    }

    public static void main(String[] args) throws IOException {
        RedJohnIsBack solution = new RedJohnIsBack();
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
