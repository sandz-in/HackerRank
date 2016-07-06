package com.sandz.hackerrank.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class JimAndTheOrder {

    class Order implements Comparable<Order> {
        public Order(int nextInt, int nextInt2, int nextInt3) {
            i = nextInt;
            s = nextInt2;
            e = nextInt3;
        }

        Integer i;
        int s;
        int e;

        @Override
        public int compareTo(Order o) {
            if (this.s + this.e < o.s + o.e)
                return -1;
            else if (this.s + this.e > o.s + o.e)
                return 1;
            return (this.i.compareTo(o.i));
        }
    }

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int n = nextInt();
        List<Order> orders = new ArrayList<Order>();
        for (int i = 1; i <= n; i++) {
            Order o = new Order(i, nextInt(), nextInt());
            orders.add(o);
        }
        Collections.sort(orders);
        for (Order order : orders) {
            System.out.print(order.i + " ");
        }
        ;
    }

    public static void main(String[] args) throws IOException {
        JimAndTheOrder solution = new JimAndTheOrder();
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
