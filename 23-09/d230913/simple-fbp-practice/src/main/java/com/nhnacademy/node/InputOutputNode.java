package com.nhnacademy.node;

import com.nhnacademy.exception.AlreadyExistException;
import com.nhnacademy.exception.InvalidArgumentException;
import com.nhnacademy.exception.OutOfBoundsException;
import com.nhnacademy.message.Message;
import com.nhnacademy.port.Port;

public class InputOutputNode extends ActivateNode {
    private final Port[] ports;
    private final Port[] peerPorts;

    InputOutputNode(int inputCount, int outputCount) {
        super();
        if (inputCount <= 0 || outputCount <= 0) {
            throw new InvalidArgumentException();
        }
        ports = new Port[inputCount];
        peerPorts = new Port[outputCount];

        for (int i = 0; i < inputCount; i++) {
            ports[i] = new Port();
        }
    }

    public void connect(int index, Port port) {
        if (index < 0 || peerPorts.length <= index) {
            throw new OutOfBoundsException();
        }
        peerPorts[index] = port;
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

    public void output(Message message) {
        for (Port port : peerPorts) {
            if (port != null) {
                port.put(message);
            }
        }
    }
}
