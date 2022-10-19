package com.oop_pub.exceptions.ex4;

import java.util.EnumSet;

public abstract class LoggerBase {

    private final EnumSet<LogLevel> logLevels;
    private LoggerBase next;

    public LoggerBase(EnumSet<LogLevel> logLevels) {
        this.logLevels = logLevels;
    }

    public void setNext(LoggerBase nextLogger) {
        next = nextLogger;
    }

    protected abstract void writeMessage(String message);

    public void message(String message, LogLevel severity) {
        if(logLevels.contains(severity)) {
            writeMessage(message);
        }
        if(next != null) {
            next.message(message, severity);
        }
    }

}
