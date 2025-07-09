package com.example.external;

import ru.mathemator.demo.javahistory.java1_0.classloader.RunnableHello;

public class Hello implements RunnableHello {
    public void greet() {
        System.out.println("Hello from external package!");
    }
}