package com.nhnacademy.node;

import com.nhnacademy.message.LongMessage;
import com.nhnacademy.message.Message;

public class AddNode extends InputOutputNode {

    public AddNode(int inputCount, int outputCount) {
        super(inputCount, outputCount);
    }

    @Override
    void process() {
        boolean accept = true;

        for (int i = 0; i < getInputPortCount(); i++) {
            accept &= getInputPort(i).hasMessage();
        }

        if (accept) {
            long result = 0;
            for (int i = 0; i < getInputPortCount(); i++) {
                Message message = getInputPort(i).get();
                if (message instanceof LongMessage) {
                    result += ((LongMessage) message).getPayload();
                }
            }
            output(new LongMessage(result));
        }
    }

}
