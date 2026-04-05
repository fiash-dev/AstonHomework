package ru.aston.hometask.Module2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonParser {

    public List<Student> loadStudentsFromJson(String filePath) {
        try {
            String jsonContent = Files.readString(Paths.get(filePath));

            Gson gson = new Gson();
            Type studentListType = new TypeToken<List<Student>>() {}.getType();
            List<Student> students = gson.fromJson(jsonContent, studentListType);
            return students;

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (com.google.gson.JsonSyntaxException e) {
            System.err.println("Ошибка синтаксиса JSON: " + e.getMessage());
        }
        return null;
    }

}
