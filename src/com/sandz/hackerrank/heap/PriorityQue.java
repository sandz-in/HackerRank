package com.sandz.hackerrank.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PriorityQue {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            int choice = nextInt();
            switch (choice) {
            case 1:
                int no = nextInt();
                heap.add(no);
                break;
            case 2:
                int index = nextInt();
                heap.remove(index);
                break;
            case 3:
                System.out.println(heap.peek());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        PriorityQue solution = new PriorityQue();
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
