package ru.mathemator.demo.javahistory.java1_1.reflection;

import java.lang.reflect.*;

public class ReflectionExample {

    public static void main(String[] args) throws Exception {
        // Получаем объект Class по имени
        Class<?> catClass = Class.forName("ru.mathemator.demo.javahistory.java1_1.Cat");

        // Создаем экземпляр через newInstance() (в 1.1 только так)
        Object cat = catClass.newInstance(); // метод устарел позже, но в 1.1 — единственный способ

        // Получаем метод sayHello и вызываем его
        Method sayHelloMethod = catClass.getMethod("sayHello");
        sayHelloMethod.invoke(cat);

        // Получаем приватное поле "name"
        Field nameField = catClass.getDeclaredField("name");
        nameField.setAccessible(true); // в 1.1 это появилось!
        nameField.set(cat, "Макотькинс");

        // Вызываем снова
        sayHelloMethod.invoke(cat);
    }
}