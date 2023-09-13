package com.nhnacademy.node;

import com.nhnacademy.message.StringMessage;
import com.nhnacademy.message.LongMessage;

import com.nhnacademy.port.Port;

public class TerminalOutNode extends OutputNode {

    public TerminalOutNode() {
        this(1);
    }

    public TerminalOutNode(int count) {
        super(count);
    }

    public void process() {
        for (int i = 0; i < getInputPortCount(); i++) {
            Port port = getInputPort(i);
            if (port.hasMessage()) {
                if (port.isStringMessage())
                    System.out.println(((StringMessage) port.get()).getMessage());
                else if (port.isLongMessage())
                    System.out.println(((LongMessage) port.get()).getPayload());

            }
        }
    }
}
