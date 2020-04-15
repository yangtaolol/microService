package com.yangtao.stack;

import com.yangtao.linkedList.Iterator;
import com.yangtao.linkedList.LinkedList;

public class Calculator {

    private Calculator(){}

    public static int calculate(String expression) {
        LinkedList<String> list = format(expression);
        Stack<Integer> stack = new Stack<>();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (isNumber(next)) {
                stack.push(Integer.parseInt(next));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                char operator = next.charAt(0);
                Integer result = calculate(num1, num2, operator);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static String toPostfixExpression(String expression) {
        LinkedList<String> format = format(expression);
        Iterator<String> iterator = format.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static boolean isNumber(String string) {
        if (string.length() > 1) {
            return true;
        } else if (check(string.charAt(0)) == 0) {
            return true;
        }
        return false;
    }

    private static int calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            case '*':
                return num1 * num2;
            case '^':
                return (int) Math.pow((double) num2, (double) num1);
            default:
                throw new IllegalArgumentException("Illegal operator:" + operator);
        }
    }

    private static LinkedList<String> format(String expression) {
        LinkedList<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] chars = expression.toCharArray();
        label:
        for (char c : chars) {
            //忽略空格
            if (c == ' ') {
                continue;
            }
            int out = check(c);
            if (out < 0) {
                throw new RuntimeException("非法符号：" + c);
            }
            //数字直接输出
            if (out == 0) {
                sb.append(c);
                continue;
            }
            if (sb.length() != 0) {
                list.add(sb.toString());
                sb.delete(0, sb.length());
            }
            //栈里为空则直接入栈
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            char top = stack.top();
            //输出括号里的内容
            if (c == ')') {
                while (true) {
                    if (stack.isEmpty()) {
                        throw new RuntimeException("缺失括号！");
                    }
                    char pop = stack.pop();
                    if (pop == '(') {
                        continue label;
                    }
                    list.add(String.valueOf(pop));
                }
            }
            //判断优先级
            if (check(top) < out || top == '(') {
                stack.push(c);
            } else {
                list.add(String.valueOf(stack.pop()));
                stack.push(c);
            }
        }
        if (sb.length() != 0) {
            list.add(sb.toString());
        }
        //输出栈里剩余的元素
        while (!stack.isEmpty()) {
            char pop = stack.pop();
            if (pop == '(') {
                throw new RuntimeException("缺失括号！");
            }
            list.add(String.valueOf(pop));
        }
        return list;
    }


    private static int check(char c) {
        if (c >= 48 && c <= 57) {
            return 0;
        }
        int result = -1;
        switch (c) {
            case '+':
            case '-':
                result = 1;
                break;
            case '*':
                result = 2;
                break;
            case '(':
            case ')':
                result = 10;
                break;
            case '^':
                result = 3;
                break;
        }
        return result;
    }
}