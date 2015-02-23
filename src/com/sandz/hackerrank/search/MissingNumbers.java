package com.sandz.hackerrank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class MissingNumbers {
    public BufferedReader br;
    public StringTokenizer st;
    public PrintWriter out;

    private void solve() throws IOException {
        int sizeA = nextInt();
        int[] a = integerArray(sizeA);
        int sizeB = nextInt();
        int[] b = integerArray(sizeB);
        Map<Integer, Integer> aMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> bMap = new HashMap<Integer, Integer>();
        counter(a, aMap);
        counter(b, bMap);
        List<Integer> uniqueList = new ArrayList<Integer>();
        for (Integer x : bMap.keySet()) {
            Integer aCount = aMap.get(x);
            Integer bCount = bMap.get(x);
            if (!aCount.equals(bCount)) {
                uniqueList.add(x);
            }
        }
        Collections.sort(uniqueList);
        for (Integer integer : uniqueList) {
            out.write(integer + " ");
        }
    }

    private void counter(int[] a, Map<Integer, Integer> aMap) {
        for (int i = 0; i < a.length; i++) {
            int key = a[i];
            Integer value = aMap.get(key);
            if (value == null) {
                value = 0;
            }
            aMap.put(key, ++value);
        }
    }

    private int[] integerArray(int sizeA) throws IOException {
        int[] a = new int[sizeA];
        for (int i = 0; i < sizeA; i++) {
            String array = nextToken();
            a[i] = Integer.parseInt(array);
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        MissingNumbers solution = new MissingNumbers();
        solution.initialize();
        solution.solve();
        solution.close();
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
