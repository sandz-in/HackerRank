package com.sandz.hackerrank.datastructures.stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BalancedParentheses {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            String token = nextToken();
            Stack<Character> chars = new Stack<Character>();
            for (int j = 0; j < token.length(); j++) {
                Character character = token.charAt(j);
                if (character == '(' || character == '[' || character == '{') {
                    chars.push(character);
                } else {
                    if (!chars.isEmpty()) {
                        if ((character == ')' && (chars.peek() == '(')) || (character == ']' && chars.peek() == '[')
                                || (character == '}' && chars.peek() == '{')) {
                            chars.pop();
                        }
                    } else {
                        chars.push(character);
                    }
                }
            }
            if (chars.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
        BalancedParentheses solution = new BalancedParentheses();
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
