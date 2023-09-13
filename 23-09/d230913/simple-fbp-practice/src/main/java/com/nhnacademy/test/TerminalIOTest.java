package com.nhnacademy.test;

import com.nhnacademy.node.TerminalInNode;
import com.nhnacademy.node.TerminalOutNode;

public class TerminalIOTest {
    public static void main(String[] args) {
        TerminalInNode in = new TerminalInNode();
        TerminalOutNode out = new TerminalOutNode();

        in.connect(0, out.getInputPort(0));

        out.start();
        in.start();
    }
}
