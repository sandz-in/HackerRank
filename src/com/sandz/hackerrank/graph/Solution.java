package com.sandz.hackerrank.graph;
/**
 * Created by sandz on 1/25/16.
 */

import java.util.Scanner;

public class Solution {

    static void max_Chocolates(int[] arr) {
        for(int i=0;i<arr.length;i++){
            long retVal = 1;
            double x = arr[i];
            retVal =(long)(Math.floor(x/2) * Math.ceil(x/2));
            System.out.println(retVal);
        }

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine());
            _arr[_arr_i] = _arr_item;
        }

        max_Chocolates(_arr);

    }
}

