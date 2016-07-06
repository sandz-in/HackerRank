package com.sandz.hackerrank.challenges.cloudera;

import java.util.Stack;

public class StringCalculator {
    public long evaluateExpression(String expression) {
        char[] characters = expression.trim().toCharArray();

        Stack<Long> values = new Stack<Long>();

        Stack<Character> ops = new Stack<Character>();

        int length = characters.length;
        for (int i = 0; i < length; i++) {
            char character = characters[i];
            if (character == ' ')
                continue;
            if (character >= '0' && character <= '9') {
                StringBuilder sbr = new StringBuilder();
                while (i < length && characters[i] >= '0' && characters[i] <= '9') {
                    character = characters[i++];
                    sbr.append(character);
                }
                values.push(Long.parseLong(sbr.toString()));
            }

            if (i >= length) {
                break;
            }

            character = characters[i];
            if (character == '(')
                ops.push(characters[i]);

            else if (character == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            else if (character == '+' || character == '-' || character == '*' || character == '/') {
                while (!ops.empty() && checkPrecedence(character, ops.peek())) {
                    Character operator = ops.pop();
                    Long value1 = values.pop();
                    Long value2 = values.pop();
                    values.push(applyOp(operator, value1, value2));
                }
                ops.push(character);
            }
        }

        while (!ops.empty()) {
            Character operator = ops.pop();
            Long value1 = values.pop();
            Long value2 = values.pop();
            values.push(applyOp(operator, value1, value2));
        }

        return values.pop();
    }

    public boolean checkPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public long applyOp(char op, long b, long a) {
        switch (op) {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new RuntimeException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        System.out.println(calculator.evaluateExpression("10 + 2 * 6"));
        System.out.println(calculator.evaluateExpression("100 * 2 + 12"));
        System.out.println(calculator.evaluateExpression("10*(2*12+6)"));
        System.out.println(calculator.evaluateExpression("100*(4+2+5*2*2+(2) )/14"));
    }
}
