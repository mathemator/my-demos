package ru.mathemator.demo.javahistory.java1_0.thread;

public class ImportantResource {

    public synchronized void work() {
        System.out.println("Здесь очень важная работа сейчас выполняется этим товарищем: "
                + Thread.currentThread());
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
