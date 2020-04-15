package com.yangtao.test;

import com.yangtao.stack.Calculator;


public class MyTest {
    public static void main(String[] args) {
        String expression = "428*(3080-1980)-742*2^3";
        System.out.println(Calculator.calculate(expression));
        System.out.println(Calculator.toPostfixExpression(expression));
    }


}
