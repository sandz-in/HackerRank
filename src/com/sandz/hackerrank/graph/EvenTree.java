package com.sandz.hackerrank.graph;
/**
 * https://www.hackerrank.com/challenges/even-tree
 * Created by sandz on 10/30/15.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

public class EvenTree {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    public class Node {
        int i;
        Set<Node> adj = new HashSet<Node>();
        int count;
        boolean visited;
    }

    public class Tree {
        public Map<Integer, Node> nodes = new HashMap<Integer, Node>();
    }

    private void solve() throws IOException {
        int v = nextInt();
        int e = nextInt();
        Tree tree = new Tree();
        for (int i = 0; i < e; i++) {
            int a = nextInt();
            int b = nextInt();
            Node nodeA = tree.nodes.get(a);
            if (nodeA == null) {
                nodeA = new Node();
                nodeA.i = a;
                tree.nodes.put(a, nodeA);
            }

            Node nodeB = tree.nodes.get(b);
            if (nodeB == null) {
                nodeB = new Node();
                nodeB.i = b;
                tree.nodes.put(b, nodeB);
            }

            nodeA.adj.add(nodeB);
            nodeB.adj.add(nodeA);
        }

        Node n = tree.nodes.values().iterator().next();
        dfs(n);
        pruneTree(n);
        System.out.println(count);
    }

    int count = 0;

    void pruneTree(Node n) {
        n.visited = true;
        for (Node x : n.adj) {
            if (!x.visited) {
                if (x.count % 2 == 0) {
                    count++;
                }
                pruneTree(x);
            }
        }

    }

    public int dfs(Node n) {
        n.count = 1;
        n.visited = true;
        for (Node x : n.adj) {
            if (!x.visited)
                n.count += dfs(x);
        }
        n.visited = false;
        return n.count;
    }

    public static void main(String[] args) throws IOException {
        EvenTree solution = new EvenTree();
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

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
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