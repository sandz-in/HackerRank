package com.sandz.hackerrank.graph;
/**
 * Created by sandz on 11/9/15.
 * https://www.hackerrank.com/challenges/the-quickest-way-up
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

public class SnakesAndLadders {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private Map<Integer, Node> nodes = new HashMap<Integer, Node>();

    private class Ladder {
        private Node destNode;
    }

    private class Node {
        Integer i;
        boolean visited = false;
        Ladder ladder;
        Set<Node> adjacentNodes = new LinkedHashSet<Node>();
        Node previousNode;
        int moves = -1;

        @Override
        public String toString() {
            return i.toString();
        }
    }

    private void solve() throws IOException {
        int testCases = nextInt();
        while (testCases > 0) {
            testCases--;
            int ladders = nextInt();
            this.nodes = new HashMap<Integer, Node>();
            for (int i = 0; i < ladders; i++) {
                int a = nextInt();
                int b = nextInt();

                Node nodeA = getOrCreateNode(a);
                Node nodeB = getOrCreateNode(b);
                Ladder de = new Ladder();
                de.destNode = nodeB;

                nodeA.ladder = de;
                nodeA.adjacentNodes.add(nodeB);
            }

            int snakes = nextInt();
            Set<Integer> snacksForSnakes = new HashSet<Integer>();
            for (int i = 0; i < snakes; i++) {
                int a = nextInt();
                snacksForSnakes.add(a);
                nextInt();
            }


            Node firstNode = getOrCreateNode(1);
            firstNode.moves = 0;
            for (int i = 2; i < 8; i++) {
                Node nextNode = getOrCreateNode(i);
                firstNode.adjacentNodes.add(nextNode);
            }

            for (int i = 2; i < 100; i++) {
                Node n = getOrCreateNode(i);
                Node nextNode = getOrCreateNode(i + 6 > 100 ? 100 : i + 6);
                n.adjacentNodes.add(nextNode);
            }

            Queue<Node> q = new LinkedList<Node>();
            q.add(firstNode);
            boolean found = false;
            while (!q.isEmpty()) {
                Node x = q.poll();
                x.visited = true;
                for (Node adjacentNode : x.adjacentNodes) {
                    if (adjacentNode.visited)
                        continue;
                    if (snacksForSnakes.contains(adjacentNode.i))
                        continue;

                    q.add(adjacentNode);

                    adjacentNode.previousNode = x;
                    if (x.ladder != null && x.ladder.destNode.equals(adjacentNode))
                        adjacentNode.moves = x.moves;
                    else
                        adjacentNode.moves = x.moves + 1;
                    if (adjacentNode.i == 100) {
                        found = true;
                        break;
                    }
                }
                if (found)
                    break;
            }
            out.println(getOrCreateNode(100).moves);
        }
    }

    private Node getOrCreateNode(int a) {
        Node nodeA = nodes.get(a);
        if (nodeA == null) {
            nodeA = new Node();
            nodeA.i = a;
            nodes.put(a, nodeA);
        }
        return nodeA;
    }

    public static void main(String[] args) throws IOException {
        SnakesAndLadders solution = new SnakesAndLadders();
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