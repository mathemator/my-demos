package ru.mathemator.demo.javahistory.java1_0.thread;

public class HeroThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread() + " Делаю героическую работу!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread() + " Меня прервали! Ого!");
                throw new RuntimeException("Исключение прерывания");
            }
        }

    }
}
