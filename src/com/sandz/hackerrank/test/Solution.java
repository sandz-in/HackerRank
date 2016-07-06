package com.sandz.hackerrank.test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++) {
            Integer count = map.get(new Character(s.charAt(i)));
            if(count == null){
                count = 0;
            }
            map.put(new Character(s.charAt(i)),++count);
            
            Integer count1 = map.get(new Character(t.charAt(i)));
            if(count1 == null){
                count1 = 0;
            }
            map.put(new Character(t.charAt(i)),--count1);
        }
        for(Integer x: map.values()) {
            if( x != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean s = solution.isAnagram("\"\"\"", "\"\"\"");
        System.out.println(s);
    }
}