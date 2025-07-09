package ru.mathemator.demo.javahistory.java1_1.rmi;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) throws Exception {
        // Ищем удалённый объект по имени
        HelloService service = (HelloService) Naming.lookup("rmi://localhost:1099/hello");

        String response = service.sayHello("Саша");
        System.out.println("Ответ от сервера: " + response);
    }
}
