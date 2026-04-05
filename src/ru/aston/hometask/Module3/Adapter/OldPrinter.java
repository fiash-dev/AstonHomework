package ru.aston.hometask.Module3.Adapter;

public class OldPrinter {
    public void printText(String text, String font, int size) {
        System.out.println("Старый принтер: текст='" + text +
                "', шрифт='" + font + "', размер=" + size);
    }
}