package com.sandz.hackerrank.challenges.cloudera;

import java.util.Stack;

public class StackSolution {
    public static void main(String[] args) {
        StackSolution solution = new StackSolution();
        System.out.println(solution.solution("13+23+*1"));
        System.out.println(solution.solution("99*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*"));
    }

    public int solution(String string) {
        Stack<Integer> values = new Stack<Integer>();
        char[] characters = string.trim().toCharArray();
        for (int i = 0; i < characters.length;) {
            char character = characters[i];
            if (character >= '0' && character <= '9') {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(character);
                values.push(Integer.parseInt(stringBuilder.toString()));
                i++;
            } else {
                while (i < characters.length && (characters[i] == '+' || characters[i] == '*')) {
                    if (values.size() <= 1)
                        return -1;
                    try {
                        values.push(applyOp(characters[i++], values.pop(), values.pop()));
                    } catch (Exception e) {
                        return -1;
                    }
                }
            }
        }
        if (values.size() > 0) {
            return values.pop();
        } else {
            return -1;
        }
    }

    public int applyOp(char op, int b, int a) throws Exception {
        switch (op) {
        case '+':
            int sum = a + b;
            if (sum < 0) {
                throw new Exception("Sum overflow");
            }
            return sum;
        case '*':
            int mul = a * b;
            if (a != 0 && (mul / a) != b) {
                throw new Exception("Multiplication overflow");
            }
            return mul;
        }
        return 0;
    }
}