package com.sandz.hackerrank.warmup;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LonelyInteger {
    static int lonelyinteger(int[] a) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            Integer count = map.get(a[i]);
            if (count == null)
                count = 0;
            map.put(a[i], ++count);
        }

        for (Integer x : map.keySet()) {
            if (map.get(x) % 2 == 1) {
                return x;
            }

        }
        return 0;

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = lonelyinteger(_a);
        System.out.println(res);

    }
}
