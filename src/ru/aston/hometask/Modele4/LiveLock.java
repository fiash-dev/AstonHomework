package ru.aston.hometask.Modele4;

public class LiveLock {
    private static class Number {
        private final String name;
        private boolean isPolite = true;

        public Number(String name) {
            this.name = name;
        }

        public void bow(Number bower) {
            while (isPolite && bower.isPolite) {
                bower.yieldTo(this);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        public void yieldTo(Number other) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        final Number first = new Number("1");
        final Number second = new Number("2");

        Thread t1 = new Thread(() -> first.bow(second));
        Thread t2 = new Thread(() -> second.bow(first));

        t1.start();
        t2.start();
    }
}