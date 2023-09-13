package com.nhnacademy.node;

import com.nhnacademy.exception.AlreadyExistException;
import com.nhnacademy.exception.InvalidArgumentException;
import com.nhnacademy.exception.OutOfBoundsException;
import com.nhnacademy.message.Message;
import com.nhnacademy.port.Port;

public abstract class InputNode extends ActivateNode {
    private final Port[] peerPorts;

    InputNode(int count) {
        super();
        if (count <= 0) {
            throw new InvalidArgumentException();
        }
        peerPorts = new Port[count];
    }

    public void connect(int index, Port port) {
        if (count <= index) {
            throw new OutOfBoundsException();
        }
        if (peerPorts[index] != null) {
            throw new AlreadyExistException();
        }
        peerPorts[index] = port;
    }

    void output(Message message) {
        for (Port port : peerPorts) {
            if (port != null) {
                port.put(message);
            }
        }
    }
}
