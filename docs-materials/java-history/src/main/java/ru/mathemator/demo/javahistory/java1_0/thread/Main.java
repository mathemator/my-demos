package ru.mathemator.demo.javahistory.java1_0.thread;

public class Main {



    public static void main(String[] args) {

        Thread heroThread = new HeroThread();
        Thread enemyThread = new EnemyThread(heroThread);

        System.out.println(Thread.currentThread() + " Запускаю противостояние");
        try {
            heroThread.start();
            Thread.sleep(100);
            enemyThread.start();
        } catch (RuntimeException | InterruptedException e) {
            System.out.println("Перехватил исключение! " + e.getMessage());
        }
        try {
            System.out.println("Подождём завершения первой демонстрации...");
            heroThread.join();
            enemyThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Демонстранция номер 2:");

        ImportantResource importantResource = new ImportantResource();
        Thread firstRacer = new FirstRacer(importantResource);
        Thread secondRacer = new SecondRacer(importantResource);
        firstRacer.start();
        secondRacer.start();
    }
}
