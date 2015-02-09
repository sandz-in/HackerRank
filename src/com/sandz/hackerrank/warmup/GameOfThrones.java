package com.sandz.hackerrank.warmup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameOfThrones {

    public static void main(String[] args) throws NumberFormatException,
            IOException {
        Scanner in = new Scanner((System.in));
        System.out.println(solve(in.nextLine()));
        in.close();
        // Long end = System.currentTimeMillis();
        // System.out.println((end - start));
    }

    private static String solve(String pattern) {
        Map<Character, Integer> characters = new HashMap<Character, Integer>();
        String retVal = "YES";
        for (int i = 0; i < pattern.length(); i++) {
            Integer count = characters.get(pattern.charAt(i));
            if (count == null)
                count = 0;
            count++;
            characters.put(pattern.charAt(i), count);
        }
        boolean encountered = false;
        for (Integer x : characters.values()) {
            if (x % 2 == 1 && !encountered) {
                encountered = true;
            } else if (x % 2 == 1 && encountered)
                return "NO";
        }
        return retVal;
    }

}
