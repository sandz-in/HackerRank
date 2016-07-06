package com.sandz.hackerrank.graph;
/**
 * Created by sandz on 1/25/16.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution1{
    static void mystery(String[] letter) {
        for(int i=0;i<letter.length;i++){
            String st = letter[i];
            long diff = 0;
            int x = 0;
            int j = st.length() - 1;
            while (x < j) {
                if (st.charAt(x) != st.charAt(j)) {
                    diff += Math.abs(st.charAt(x) - st.charAt(j));
                }
                x++;j--;
            }
            System.out.println(diff);
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int _letter_size = 0;
        _letter_size = Integer.parseInt(in.nextLine());
        String[] _letter = new String[_letter_size];
        String _letter_item;
        for(int _letter_i = 0; _letter_i < _letter_size; _letter_i++) {
            try {
                _letter_item = in.nextLine();
            } catch (Exception e) {
                _letter_item = null;
            }
            _letter[_letter_i] = _letter_item;
        }

        mystery(_letter);

    }

}