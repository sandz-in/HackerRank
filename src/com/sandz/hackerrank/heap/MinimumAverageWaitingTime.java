package com.sandz.hackerrank.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/challenges/minimum-average-waiting-time
 * 
 * @author sandz
 *
 */
public class MinimumAverageWaitingTime {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    public class Node implements Comparable<Node> {

        BigInteger startTime;
        BigInteger timeTaken;

        @Override
        public int compareTo(Node o) {
            BigInteger a = timeTaken;
            return a.compareTo(o.timeTaken);
        }

    }

    private void solve() throws IOException {
        Queue<Node> q = new PriorityQueue<Node>();
        Integer n = nextInt();
        for (int i = 0; i < n; i++) {
            BigInteger a = nextLong();
            BigInteger b = nextLong();
            Node node = new Node();
            node.startTime = a;
            node.timeTaken = b;
            q.add(node);
        }
        BigInteger sum = new BigInteger("0");
        BigInteger inst = new BigInteger("0");
        // BigInteger inst = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if ((node.startTime.compareTo(inst) > 0))
                inst = node.startTime;
            inst = inst.add(node.timeTaken);
            sum = sum.add(inst.subtract((node.startTime)));
        }
        println(sum);
        println(sum.divide(new BigInteger(n.toString())));
    }

    public static void main(String[] args) throws IOException {
        MinimumAverageWaitingTime solution = new MinimumAverageWaitingTime();
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

    private BigInteger nextLong() throws IOException {
        return new BigInteger(nextToken());
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

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
}
