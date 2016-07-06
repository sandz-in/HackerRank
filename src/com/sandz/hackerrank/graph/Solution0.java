package com.sandz.hackerrank.graph;
/**
 * Created by sandz on 1/25/16.
 */

import java.util.HashSet;

import java.util.Set;


public class Solution0 {

    public static void main(String[] args) {
        System.out.println(Solution0.palindrome("aabaa"));
    }

    static int palindrome(String str) {
        Set<String> set = new HashSet<String>();
        char charArray[] = str.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            Solution0.fetchDistinct(i, set, charArray, str);
            i++;
        }
        return set.size();
    }

    static void fetchDistinct(int level, Set<String> palidromicSet, char array[], String s1) {
        int j = level;
        while (j < array.length) {
            if (s1.substring(level, j + 1).equals((new StringBuilder(s1.substring(level, j + 1)).reverse().toString()))) {
                palidromicSet.add(s1.substring(level, j + 1));
            }
            j++;
        }

    }

}