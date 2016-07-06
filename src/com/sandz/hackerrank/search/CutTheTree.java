package com.sandz.hackerrank.search;
/**
 * Created by sandz on 8/13/15.
 * https://www.hackerrank.com/challenges/cut-the-tree
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

public class CutTheTree {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    public class Tree {
        Map<Integer, Node> nodes = new HashMap<Integer, Node>();

    }

    public class Node {
        Set<Node> adjacentNodes = new HashSet<Node>();
        Integer i;
        int childSum;
        boolean visited;

        @Override
        public String toString() {
            return i.toString();
        }
    }

    private void solve() throws IOException {
        int n = nextInt();
        Tree tree = new Tree();
        for (int i = 1; i <= n; i++) {
            Node node = new Node();
            int j = nextInt();
            node.i = i;
            node.childSum = j;
            tree.nodes.put(i, node);
        }
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt();
            int b = nextInt();
            Node nA = tree.nodes.get(a);
            Node nB = tree.nodes.get(b);
            nA.adjacentNodes.add(nB);
            nB.adjacentNodes.add(nA);
        }

        Node startNode = tree.nodes.values().iterator().next();
        dfs(startNode);
        println(bfs(startNode));
    }

    private void dfs(Node node) {
        node.visited = true;
        for (Node x : node.adjacentNodes) {
            if (x.visited)
                continue;
            dfs(x);
            node.childSum += x.childSum;
        }
        node.visited = false;
    }

    private int bfs(Node node) {
        int retVal = Integer.MAX_VALUE;
        int max = node.childSum;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node pa = queue.poll();
            pa.visited = true;
            int temp = Math.abs(max - (2 * pa.childSum));
            retVal = Math.min(retVal, temp);
            for (Node adjacentNode : pa.adjacentNodes) {
                if (adjacentNode.visited)
                    continue;
                queue.add(adjacentNode);
            }
        }
        return retVal;
    }

    public static void main(String[] args) throws IOException {
        CutTheTree solution = new CutTheTree();
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

