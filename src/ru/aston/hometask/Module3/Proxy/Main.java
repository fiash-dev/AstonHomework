package ru.aston.hometask.Module3.Proxy;

public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        System.out.println("Первый вызов для image1:");
        image1.display();

        System.out.println("\nВторой вызов для image1:");
        image1.display();

        System.out.println("\nПервый вызов для image2:");
        image2.display();
    }
}
