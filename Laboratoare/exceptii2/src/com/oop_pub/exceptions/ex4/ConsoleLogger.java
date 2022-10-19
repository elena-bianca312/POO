package com.oop_pub.exceptions.ex4;

import java.util.EnumSet;

public class ConsoleLogger extends LoggerBase {

    public ConsoleLogger(EnumSet<LogLevel> logLevels) {
        super(logLevels);
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[Console] " + message);
    }
}
