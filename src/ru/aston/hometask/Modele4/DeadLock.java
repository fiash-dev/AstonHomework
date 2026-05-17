package ru.aston.hometask.Modele4;

public class DeadLock {
    private final String name;

    public DeadLock(String name) {
        this.name = name;
    }

    private void catchThread(Object secondLock) {
        synchronized (this) {
            System.out.println(name + ": Захватил первую блокировку");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            synchronized (secondLock) {
                System.out.println(name + ": Захватил вторую блокировку");
            }
        }
    }

    public static void main(String[] args) {
        DeadLock lock1 = new DeadLock("Поток №1");
        DeadLock lock2 = new DeadLock("Поток №2");

        Thread t1 = new Thread(() -> lock1.catchThread(lock2));
        Thread t2 = new Thread(() -> lock2.catchThread(lock1));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
