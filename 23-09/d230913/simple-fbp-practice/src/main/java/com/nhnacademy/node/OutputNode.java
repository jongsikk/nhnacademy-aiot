package com.nhnacademy.node;

import com.nhnacademy.exception.InvalidArgumentException;
import com.nhnacademy.exception.OutOfBoundsException;
import com.nhnacademy.port.Port;

public abstract class OutputNode extends ActivateNode {
    private final Port[] ports;

    OutputNode(int count) {
        super();
        if (count <= 0) {
            throw new InvalidArgumentException();
        }
        ports = new Port[count];
        for (int i = 0; i < count; i++) {
            ports[i] = new Port();
        }
    }

    public int getInputPortCount() {
        return ports.length;
    }

    public Port getInputPort(int index) {
        if (index < 0 || ports.length <= index) {
            throw new OutOfBoundsException();
        }
        return ports[index];
    }
}
