package ru.aston.hometask.Module3.Adapter;

public class OldPrinterAdapter implements ModernPrinter {
    private OldPrinter oldPrinter;

    public OldPrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void print(String text) {
        oldPrinter.printText(text, "Arial", 12);
    }
}