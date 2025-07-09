package ru.mathemator.demo.javahistory.java1_0.thread;

public class EnemyThread extends Thread {

    Thread heroThread;

    public EnemyThread(Thread heroThread) {
        this.heroThread = heroThread;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            if(heroThread != null && heroThread.isAlive() && !heroThread.isInterrupted()) {
                System.out.println(Thread.currentThread() + " Хи-Хи, сейчас я прерву этого джентельмена!");
                heroThread.interrupt();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
