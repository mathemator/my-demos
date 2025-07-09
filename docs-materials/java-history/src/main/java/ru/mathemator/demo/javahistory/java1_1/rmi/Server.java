package ru.mathemator.demo.javahistory.java1_1.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;

public class Server {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();

        // Запускаем реестр RMI на порту 1099
        LocateRegistry.createRegistry(1099);

        // Регистрируем объект в реестре
        Naming.rebind("rmi://localhost:1099/hello", service);

        System.out.println("Сервер запущен...");
    }
}
