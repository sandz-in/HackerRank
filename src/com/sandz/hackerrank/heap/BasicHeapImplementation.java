package com.sandz.hackerrank.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BasicHeapImplementation {

    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    class Heap {
        int[] data = new int[1000001];
        int size = 0;

        void heapify(int x) {
            if (isLeaf(x)) {
                return;
            }
            int lval = leftIndex(x) > size ? Integer.MAX_VALUE : data[leftIndex(x)];
            int rval = rightIndex(x) > size ? Integer.MAX_VALUE : data[rightIndex(x)];
            if (lval < data[x] || rval < data[x]) {
                if (lval < rval) {
                    heapify(leftIndex(x));
                    swap(leftIndex(x), x);
                } else {
                    heapify(rightIndex(x));
                    swap(rightIndex(x), x);
                }
            }
        }

        void insert(int val) {
            data[size++] = val;
            heapifyUp(size - 1);
        }

        private void heapifyUp(int i) {
            int parent = (i - 1) / 2;
            if (parent >= 0) {
                if (data[i] < data[parent]) {
                    swap(parent, i);
                    heapifyUp(parent);
                }
            }
        }

        private void swap(int leftIndex, int x) {
            int temp = data[x];
            data[x] = data[leftIndex];
            data[leftIndex] = temp;
        }

        private int leftIndex(int x) {
            return 2 * x + 1;
        }

        private int rightIndex(int x) {
            return 2 * x + 2;
        }

        void buildHeap() {
            for (int i = data.length - 1; i >= 0; i--) {
                heapify(i);
            }
        }

        private boolean isLeaf(int x) {
            return x > (size) / 2;
        }

        int extractMin() {
            int retVal = data[0];
            // delete(0);
            return retVal;
        }

        int search(int val) throws Exception {
            for (int i = 0; i <= size; i++) {
                if (data[i] == val)
                    return i;
            }

            throw new Exception("ss");
        }

        void delete(int i) {
            data[i] = data[size - 1];
            size--;
            heapify(i);
        }
    }

    private void solve() throws Exception {
        Heap heap = new Heap();
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            int choice = nextInt();
            switch (choice) {
            case 1:
                int no = nextInt();
                heap.insert(no);
                break;
            case 2:
                int val = nextInt();
                heap.delete(heap.search(val));
                break;
            case 3:
                System.out.println(heap.extractMin());
                if (i >= 140)
                    System.out.print("");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BasicHeapImplementation solution = new BasicHeapImplementation();
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
