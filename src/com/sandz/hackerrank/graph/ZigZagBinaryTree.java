package com.sandz.hackerrank.graph;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ZigZagBinaryTree {

    BTree btree;

    public class BTree {
        Map<Integer, Node> nodes = new HashMap<Integer, Node>();

        Node getNode(int i) {
            if (i == -1)
                return null;
            Node node = nodes.get(i);
            if (node == null) {
                node = new Node();
                node.i = i;
                nodes.put(i, node);
            }
            return node;
        }
    }

    public class Node {
        int i;
        Node leftNode;
        Node rightNode;
    }

    void solve(BTree btree) {
        Node rootNode = btree.getNode(1);
        Stack<Node> ltor = new Stack<Node>();
        Stack<Node> rtol = new Stack<Node>();
        ltor.push(rootNode);
        boolean rtolv = false;
        while (true) {
            if (ltor.isEmpty() && rtol.isEmpty())
                break;
            if (!rtolv) {
                while (!ltor.isEmpty()) {
                    Node n = ltor.pop();
                    System.out.print(n.i + " ");
                    if (n.leftNode != null)
                        rtol.push(n.leftNode);
                    if (n.rightNode != null)
                        rtol.push(n.rightNode);
                }
                rtolv = true;
            } else {
                while (!rtol.isEmpty()) {
                    Node n = rtol.pop();
                    System.out.print(n.i + " ");
                    if (n.rightNode != null)
                        ltor.push(n.rightNode);
                    if (n.leftNode != null)
                        ltor.push(n.leftNode);
                }
                rtolv = false;
            }
        }
    }

    private void processInput() throws IOException {
        int i[][] = { { 1, 2, 3 }, { 2, 4, 5 }, { 3, 6, 7 }, { 7, 10, 9 }, { 4, 8, -1 } };
        btree = new BTree();
        for (int j = 0; j < i.length; j++) {
            Node n = btree.getNode(i[j][0]);
            n.leftNode = btree.getNode(i[j][1]);
            n.rightNode = btree.getNode(i[j][2]);
        }
    }

    public static void main(String[] args) throws IOException {
        ZigZagBinaryTree solution = new ZigZagBinaryTree();
        solution.processInput();
        solution.solve(solution.btree);
    }

}
