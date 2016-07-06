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

public class LargestRectangleDC {

    public class Tuple {
        int min = -1;
        int size = -1;
        int product = -1;

    }

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int n = nextInt();
        int[] a = nextIntArray(n);
        Tuple maxT = calculateArea(a, 0, n - 1);
        System.out.println(maxT.min);
    }

    private Tuple calculateArea(int[] a, int i, int j) {
        if (i > j)
            return new Tuple();

        if(i == j){
            // retur
        }
        int mid = (i + j) / 2;
        Tuple left = calculateArea(a, i, mid);
        Tuple right = calculateArea(a, mid + 1, j);
        merge(a, left, right);
        return null;
    }

    private void merge(int[] a, Tuple left, Tuple right) {

    }

    public static void main(String[] args) throws IOException {
        LargestRectangleDC solution = new LargestRectangleDC();
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
