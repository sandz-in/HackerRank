package com.sandz.hackerrank.airwatch;
/**
 * https://www.hackerrank.com/contests/airwatch-nc-state/challenges/number-of-groups
 * Created by sandz on 10/13/15.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

public class NumberOfGroups {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;
    Map<Integer, Node> nodes = new HashMap<Integer, Node>();

    public class Node implements Comparable {
        Integer n;
        Set<Node> friends = new HashSet<Node>();
        boolean visited = false;


        @Override
        public int compareTo(Object o) {
            if (o == null || !(o instanceof Node))
                return 1;
            Node other = (Node) o;
            return this.n.compareTo(other.n);

        }

    }

    private void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        for (int i = 0; i < n; i++) {
            Node node = new Node();
            node.n = i;
            nodes.put(i, node);

        }
        for (int i = 0; i < m; i++) {
            int a = nextInt();
            int b = nextInt();
            Node na = nodes.get(a);
            Node nb = nodes.get(b);
            na.friends.add(nb);
            nb.friends.add(na);
        }
        int k = nextInt();
        for (int i = 0; i < k; i++) {
            int x = nextInt();
            Node nx = nodes.get(x);
            nx.friends.clear();
            for (int j = 0; j < nodes.size(); j++) {
                nodes.get(j).friends.remove(nx);
            }
        }

        int count = 0;

        for (int i = 0; i < nodes.size(); i++) {
            Node a = nodes.get(i);
            if (a.visited) {
                continue;
            }
            count++;
            Stack<Node> q = new Stack<Node>();
            q.addAll(a.friends);
//            Iterator<Node> iterator = q.iterator();
            while (!q.isEmpty()) {
                Node pop = q.pop();
                if (pop.visited)
                    continue;
                pop.visited = true;
                for (Node friend : pop.friends) {
                    if (!friend.visited)
                        q.add(friend);
                }
            }
        }
        println(count);
    }

    public static void main(String[] args) throws IOException {
        NumberOfGroups solution = new NumberOfGroups();
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
