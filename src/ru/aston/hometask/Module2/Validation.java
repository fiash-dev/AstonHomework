package ru.aston.hometask.Module2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Validation {
    public boolean isValidation(String filePath) {
        Path jsonPath = Paths.get(filePath);

        if (filePath.isEmpty()) {
            System.err.println("Ошибка: путь к файлу не может быть пустым!");
            return false;
        }

        // Валидация файла
        if (!Files.exists(jsonPath)) {
            System.err.println("Ошибка: файл не найден: " + jsonPath.toAbsolutePath());
            return false;
        }

        if (!Files.isRegularFile(jsonPath)) {
            System.err.println("Ошибка: указанный путь не является файлом: " + filePath);
            return false;
        }

        if (!Files.isReadable(jsonPath)) {
            System.err.println("Ошибка: нет прав на чтение файла: " + filePath);
            return false;
        }
        return true;
    }
}
