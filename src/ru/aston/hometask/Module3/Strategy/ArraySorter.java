package ru.aston.hometask.Module3.Strategy;

public class ArraySorter {
    private SortingStrategy sortStrategy;

    public ArraySorter(SortingStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void setSortStrategy(SortingStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void sort(int[] array) {
        sortStrategy.sort(array);
    }
}
