package com.yangtao.commandpatern;

public class Client {

    public static void main(String[] args) {
        Command command = new PrintCommand("hahaha");
        Invoker invoker = new Invoker(command);
        invoker.invoke();
    }
}
