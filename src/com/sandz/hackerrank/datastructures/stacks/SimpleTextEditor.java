package com.sandz.hackerrank.datastructures.stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class SimpleTextEditor {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int q = nextInt();
        Stack<Integer> prevLength = new Stack<Integer>();
        Stack<Integer> prevOp = new Stack<Integer>();
        Stack<String> prevCutStr = new Stack<String>();
        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < q; i++) {
            int choice = nextInt();
            if (choice == 1) {
                prevOp.push(choice);
                String can = nextToken();
                prevLength.push(can.length());
                push(s, can);
            } else if (choice == 2) {
                prevOp.push(choice);
                int k = nextInt();
                prevCutStr.push(delete(s, k));
            } else if (choice == 3) {
                int k = nextInt();
                println(s.get(k - 1));
            } else if (choice == 4) {
                int prev = prevOp.pop();
                if (prev == 1) {
                    delete(s, prevLength.pop());
                } else if (prev == 2) {
                    push(s, prevCutStr.pop());
                }
            }
        }
    }

    private void println(Object o) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(o);
        stringBuilder.append("\n");
        out.write(stringBuilder.toString());
    }

    private String delete(Stack<Character> s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        while (k > 0) {
            stringBuilder.append(s.pop());
            k--;
        }
        return stringBuilder.reverse().toString();
    }

    private void push(Stack<Character> s, String can) {
        for (int i = 0; i < can.length(); i++) {
            s.push(can.charAt(i));
        }
    }

    public static void main(String[] args) throws IOException {
        SimpleTextEditor solution = new SimpleTextEditor();
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
