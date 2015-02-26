package com.sandz.hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class SimilarPair {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;
    Map<Integer, Node> nodes = new HashMap<Integer, Node>();
    int target = 0;
    int count = 0;
    class Node {
        int i;
        Node parentNode;
        List<Node> parentNodes = new ArrayList<Node>();
        Node(int i) {
            this.i = i;
        }

        @Override
        public String toString() {
            String retVal = i + " ";
            for (Node node : parentNodes) {
                retVal += i + " " + node.i;
            }
            return retVal;
        }

    }
    private void solve() throws IOException {
        int noOfNodes = nextInt();
        target = nextInt();
        for (int i = 1; i <= noOfNodes; i++) {
            Node node = new Node(i);
            nodes.put(i, node);
        }

        for (int i = 1; i < noOfNodes; i++) {
            int src = nextInt();
            int dest = nextInt();
            Node srcNode = nodes.get(src);
            Node destNode = nodes.get(dest);
            destNode.parentNode = srcNode;
        }

        for (Node i : this.nodes.values()) {
            counter(i, i.parentNode);
        }
        println(count);
    }

    private void counter(Node srcNode, Node destNode) {
        while (destNode != null) {
            if (Math.abs(destNode.i - srcNode.i) <= target) {
                count++;
            }
            destNode = destNode.parentNode;
        }
    }

    public static void main(String[] args) throws IOException {
        SimilarPair solution = new SimilarPair();
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
