package ru.aston.hometask.Module3.Strategy;

public class Main {
    public static void main(String[] args) {
        int[] array = {3, 2, 2, 8, 5, 4, 1, 7, 0, 9};
        ArraySorter sorter = new ArraySorter(new BubbleSort());
        sorter.sort(array);
        sorter.setSortStrategy(new InsertionSort());
        sorter.sort(array);
    }
}
