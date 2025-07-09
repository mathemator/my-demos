package ru.mathemator.demo.javahistory.java1_0.thread;

public class SecondRacer extends Thread {
    ImportantResource importantResource;

    public SecondRacer(ImportantResource importantResource) {
        this.importantResource = importantResource;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            importantResource.work();
        }
    }
}
