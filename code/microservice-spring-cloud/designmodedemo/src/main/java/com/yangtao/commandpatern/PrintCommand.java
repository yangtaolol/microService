package com.yangtao.commandpatern;

public class PrintCommand implements Command{

    private Receiver receiver;

    private String content;

    public PrintCommand(String content) {
        this.content = content;
        this.receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.action(content);
    }
}
