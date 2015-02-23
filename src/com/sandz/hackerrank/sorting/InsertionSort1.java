package com.sandz.hackerrank.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class InsertionSort1 {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int size = nextInt();
        int[] a = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = nextInt();
        }
        int temp = a[a.length - 1];
        int i = a.length - 2;
        for (; i >= 0; i--) {
            if (temp < a[i]) {
                a[i + 1] = a[i];
                printArray(a);
            } else {
                a[i + 1] = temp;
                break;
            }
        }
        a[i + 1] = temp;
        printArray(a);
    }

    private void printArray(int[] a) {
        for (int i : a) {
            out.write(i + " ");
        }
        out.write("\n");
    }

    public static void main(String[] args) throws IOException {
        InsertionSort1 solution = new InsertionSort1();
        solution.initialize();
        solution.solve();
        solution.close();
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
