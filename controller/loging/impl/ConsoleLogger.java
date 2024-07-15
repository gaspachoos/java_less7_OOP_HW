package controller.loging.impl;

import java.time.LocalDateTime;

import controller.loging.Loggable;

public class ConsoleLogger implements Loggable {
    @Override
    public void log(String message) {
        System.err.println(LocalDateTime.now() + " <--- : ---> " + message);
    }
}