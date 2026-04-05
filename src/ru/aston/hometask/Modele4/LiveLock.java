package ru.aston.hometask.Modele4;

public class LiveLock {
    private static class Friend {
        private final String name;
        private volatile boolean isPolite = true;

        public Friend(String name) {
            this.name = name;
        }

        public void bow(Friend bower) {
            while (isPolite && bower.isPolite) {
                System.out.println(name + ": Прошу, проходите первым!");
                bower.yieldTo(this);
                try {
                    Thread.sleep(100); // Имитация задержки
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(name + ": Наконец-то прошёл!");
        }

        public void yieldTo(Friend other) {
            System.out.println(name + ": Хорошо, проходите вы.");
        }
    }

    public static void main(String[] args) {
        final Friend alice = new Friend("Алиса");
        final Friend vanay = new Friend("Ваня");

        Thread t1 = new Thread(() -> alice.bow(vanay));
        Thread t2 = new Thread(() -> vanay.bow(alice));

        t1.start();
        t2.start();
    }
}