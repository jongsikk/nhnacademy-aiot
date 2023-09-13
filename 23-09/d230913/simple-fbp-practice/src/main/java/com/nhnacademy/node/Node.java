package com.nhnacademy.node;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Node {
    static Integer count = 0;
    final String id;
    Logger logger;

    Node() {
        count++;
        id = String.format("%s-%02d", getClass().getSimpleName(), count);
        log.trace("create node : {}", id);
    }

    public static Integer getCount() {
        return count;
    }

    public String getId() {
        return id;
    }

    public abstract String getName();

    public abstract void setName(String name);

}
