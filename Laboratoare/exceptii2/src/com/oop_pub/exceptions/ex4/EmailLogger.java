package com.oop_pub.exceptions.ex4;

import java.util.EnumSet;

public class EmailLogger extends LoggerBase {

    public EmailLogger(EnumSet<LogLevel> logLevels) {
        super(logLevels);
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[Email] " + message);
    }
}
