package ru.aston.hometask.Module3.Strategy;

public class BubbleSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("Сортировки пузырьком");
        long startTime = System.nanoTime();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        }

        long executionTimeNano = System.nanoTime() - startTime;
        double executionTimeMs = executionTimeNano / 1_000_000.0;
        System.out.println("Время выполнения: " + executionTimeMs + " мс");
    }
}
