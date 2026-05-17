package ru.aston.hometask.Module3.Proxy;

public class ProxyImage implements Image {
    private volatile RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            synchronized (this) {
                if (realImage == null) {
                    realImage = new RealImage(filename);
                }
            }
        }
        realImage.display();
    }
}

