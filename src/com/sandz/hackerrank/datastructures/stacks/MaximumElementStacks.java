package com.sandz.hackerrank.datastructures.stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class MaximumElementStacks {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        Stack<Integer> s = new Stack<Integer>();
        Stack<Integer> max = new Stack<Integer>();
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            int choice = nextInt();
            if (choice == 1) {
                int a = nextInt();
                s.push(a);
                if (!max.isEmpty()) {
                    int currMax = max.peek();
                    if (a >= currMax)
                        max.push(a);
                } else {
                    max.push(a);
                }
            } else if (choice == 2) {
                int a = s.pop();
                if (!max.isEmpty()) {
                    int currMax = max.peek();
                    if (currMax == a)
                        max.pop();
                }
            } else {
                System.out.println(max.peek());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        MaximumElementStacks solution = new MaximumElementStacks();
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
