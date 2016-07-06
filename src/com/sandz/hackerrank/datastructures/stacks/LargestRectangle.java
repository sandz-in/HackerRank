package com.sandz.hackerrank.datastructures.stacks;

/**
 * https://www.hackerrank.com/challenges/largest-rectangle
 * @author sandz
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class LargestRectangle {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int n = nextInt();
        int[] a = nextIntArray(n);
        BigInteger bigInteger;
        BigInteger max = new BigInteger("-1");
        for (int i = 0; i < n; i++) {
            Integer p = a[i];
            bigInteger = new BigInteger(p.toString());
            if (bigInteger.compareTo(max) == 1) {
                max = bigInteger;
            }
            BigInteger min = new BigInteger(p.toString());
            for (int j = i + 1; j < n; j++) {
                Integer x = a[j];
                BigInteger val = new BigInteger(new String(x.toString()));
                if (min.compareTo(val) == 1) {
                    min = val;
                }
                Integer z = j - i + 1;
                bigInteger = min.multiply(new BigInteger(z.toString()));
                if (bigInteger.compareTo(max) == 1) {
                    max = bigInteger;
                }
            }
        }
        System.out.println(max.toString());

    }

    public static void main(String[] args) throws IOException {
        LargestRectangle solution = new LargestRectangle();
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

    private int[] nextIntArray(int n) throws IOException {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        return a;
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
