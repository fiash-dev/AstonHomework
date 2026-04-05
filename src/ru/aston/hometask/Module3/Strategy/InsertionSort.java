package ru.aston.hometask.Module3.Strategy;

public class InsertionSort implements SortingStrategy {

    @Override
    public void sort(int[] array) {
        System.out.println("Реализация сортировки вставками");
        long startTime = System.nanoTime();
        int j;
        for (int i = 1; i < array.length; i++) {
            int swap = array[i];
            for (j = i; j > 0 && swap < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = swap;
        }
        long executionTimeNano = System.nanoTime() - startTime;
        double executionTimeMs = executionTimeNano / 100_000.0;
        System.out.println("Время выполнения: " + executionTimeMs + " мс");
    }
}
