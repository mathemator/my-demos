package ru.mathemator.demo.javahistory.java1_0.classloader;

import java.io.File;

public class LoaderTest {
    public static void main(String[] args) throws Exception {
        MyClassLoader loader = new MyClassLoader("external-classes");
        Class<?> clazz = loader.loadClass("com.example.external.Hello");

        Object instance = clazz.newInstance();

        RunnableHello hello = (RunnableHello) instance;
        hello.greet();
    }
}
