package com.sandz.hackerrank.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class InsertionSort2 {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int size = nextInt();
        int[] a = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = nextInt();
        }
        for (int i=1; i < a.length; i++) {
            int x = a[i];
            int j=i-1;
            while(j >= 0 && a[j]>x){
                    a[j+1] =  a[j];
                    j--;
            }
            a[j+1] = x;
            printArray(a);
        }
    }

    private void printArray(int[] a) {
        for (int i : a) {
            out.write(i + " ");
        }
        out.write("\n");
    }

    public static void main(String[] args) throws IOException {
        InsertionSort2 solution = new InsertionSort2();
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
