package com.sandz.hackerrank.challenges.cloudera;

/* A Java program to evaluate a given expression where tokens are separated 
by space.
Test Cases:
	"10 + 2 * 6"		 ---> 22
	"100 * 2 + 12"		 ---> 212
	"100 * ( 2 + 12 )"	 ---> 1400
	"100 * ( 2 + 12 ) / 14" ---> 100 
*/
import java.util.Stack;

public class StringCalculator {
    public static int evaluate(String expression) {
        char[] tokens = expression.toCharArray();

        Stack<Integer> values = new Stack<Integer>();

        Stack<Character> ops = new Stack<Character>();

        int length = tokens.length;
        System.out.println(length);
        for (int i = 0; i < length; i++) {
            if (tokens[i] == ' ')
                continue;
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Integer.parseInt(sbuf.toString()));
            }

            else if (tokens[i] == '(')
                ops.push(tokens[i]);

            else if (tokens[i] == ')') {
                System.out.println("ddd");
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                ops.push(tokens[i]);
            }
        }

        while (!ops.empty()) {
            Character operator = ops.pop();
            Integer value1 = values.pop();
            Integer value2 = values.pop();
            values.push(applyOp(operator, value1, value2));
        }

        return values.pop();
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static int applyOp(char op, int b, int a) {
        switch (op) {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        // System.out.println(StringCalculator.evaluate("10 + 2 * 6"));
        // System.out.println(StringCalculator.evaluate("100 * 2 + 12"));
        System.out.println(StringCalculator.evaluate("10 * ( 2 + 12 * 6 ) "));
        System.out.println(StringCalculator.evaluate("100 * ( 2 + 12 ) / 14"));
    }
}
