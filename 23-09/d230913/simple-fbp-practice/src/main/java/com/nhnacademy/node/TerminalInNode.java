package com.nhnacademy.node;

import java.util.Scanner;
import com.nhnacademy.message.StringMessage;

public class TerminalInNode extends InputNode {
    Scanner sc;

    public TerminalInNode(int count) {
        super(count);
    }

    public TerminalInNode() {
        this(1);
    }

    void preprocess() {
        sc = new Scanner(System.in);
        setInterval(1);
    }

    void process() {
        output(new StringMessage(sc.nextLine()));
    }

    void postprocess() {
        sc.close();
    }
}
