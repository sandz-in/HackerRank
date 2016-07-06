package com.sandz.hackerrank.graph;
/**
 * Created by sandz on 1/25/16.
 */

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution2 {
    static String isitpossible(int a, int b, int c, int d) {
        String retVal = "No";
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int omax = Math.max(d, c);
        int omin = Math.min(d, c);
        while (true) {
            if (omax < max || omin < min)
                break;
            if (omax == max && omin == min) {
                retVal = "Yes";
                break;
            }
            int diff = omax - omin;
            omax = Math.max(diff, omin);
            omin = Math.min(diff, omin);
        }
        System.out.println(retVal);
        return retVal;

    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        String res;
//        int _a;
//        _a = Integer.parseInt(in.nextLine());
//
//        int _b;
//        _b = Integer.parseInt(in.nextLine());
//
//        int _c;
//        _c = Integer.parseInt(in.nextLine());
//
//        int _d;
//        _d = Integer.parseInt(in.nextLine());

        res = isitpossible(1, 4, 5, 9);
        res = isitpossible(1, 4, 14, 22);
        res = isitpossible(1, 4, 19, 33);
        res = isitpossible(1, 1, 1, 1);
//        bw.write(res);
//        bw.newLine();
//
//        bw.close();
    }
}
