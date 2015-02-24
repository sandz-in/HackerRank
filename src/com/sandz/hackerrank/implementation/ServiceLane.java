package com.sandz.hackerrank.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ServiceLane {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    private static void solve() throws IOException {
        int length = nextInt();
        int testcases = nextInt();
        boolean[][] vehicle = new boolean[length][3];
        for (int i = 0; i < length; i++) {
            int w = nextInt();
            switch (w) {
                case 3 :
                    vehicle[i][2] = true;
                case 2 :
                    vehicle[i][1] = true;
                case 1 :
                    vehicle[i][0] = true;
                    break;
            }
        }
        for (int x = 0; x < testcases; x++) {
            int i = nextInt();
            int j = nextInt();
            findVehicleSize(vehicle, i, j);
        }

    }
    private static void findVehicleSize(boolean[][] vehicle, int i, int j) {
        int temp = 2;
        for (int x = i; x <= j;) {
            if (!vehicle[x][temp]) {
                temp--;
            } else {
                x++;
            }
        }
        System.out.println(temp + 1);

    }
    public static void main(String[] args) throws IOException {
        InputStream input = System.in;
        PrintStream output = System.out;
        br = new BufferedReader(new InputStreamReader(input));
        out = new PrintWriter(output);
        solve();
        br.close();
        out.close();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static String nextToken() throws IOException {
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
