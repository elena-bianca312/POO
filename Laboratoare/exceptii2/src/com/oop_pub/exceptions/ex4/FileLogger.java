package com.oop_pub.exceptions.ex4;

import java.util.EnumSet;

public class FileLogger extends LoggerBase {

    public FileLogger(EnumSet<LogLevel> logLevels) {
        super(logLevels);
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[File] " + message);
    }
}
