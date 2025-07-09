package ru.mathemator.demo.javahistory.java1_0.thread;

public class FirstRacer extends Thread {
    ImportantResource importantResource;

    public FirstRacer(ImportantResource importantResource) {
        this.importantResource = importantResource;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            importantResource.work();
        }
    }
}
