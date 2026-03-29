package ru.aston.hometask.Module3.Adapter;

public class Main {
    public static void main(String[] args) {
        OldPrinter oldPrinter = new OldPrinter();

        ModernPrinter printer = new OldPrinterAdapter(oldPrinter);

        printer.print("Привет, мир!");
        printer.print("Это тестовая печать");
    }
}
