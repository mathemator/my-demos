package ru.mathemator.demo;

import java.nio.file.Paths;

public class NativeExample {

    public native void sayHelloFromC();

    static {
        System.loadLibrary("native_example");
    }

    public static void main(String[] args) {
        new NativeExample().sayHelloFromC();
    }
}
