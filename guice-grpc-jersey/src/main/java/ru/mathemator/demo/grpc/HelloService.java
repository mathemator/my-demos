package ru.mathemator.demo.grpc;

public class HelloService {
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }
}