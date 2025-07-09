package ru.mathemator.demo.javahistory.java1_1.rmi;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {

    protected HelloServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return "Привет, " + name + "! Это RMI-сервер!";
    }
}
