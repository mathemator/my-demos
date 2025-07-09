package ru.mathemator.demo.javahistory.java1_0.securitymanager;


public class MySecurityManager extends SecurityManager {

    @Override
    public void checkRead(String file) {
        if (file.endsWith(".secret")) {
            throw new SecurityException("Reading secret files is not allowed: " + file);
        }
    }

    @Override
    public void checkExit(int status) {
        throw new SecurityException("System exit is not allowed!");
    }

    // Можно добавлять другие методы, например checkConnect, checkWrite и т.д.
}
