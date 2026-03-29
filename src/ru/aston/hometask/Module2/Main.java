package ru.aston.hometask.Module2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        List<Student> students = null;
        try {
            students = mapper.readValue(new File("src/ru/aston/hometask/Module2/resource/students.json"), new TypeReference<List<Student>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .distinct()
                .sorted(Comparator.comparingInt(Book::getPages))
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска найденной книги: " + year),
                        () -> System.out.println("Такая книга отсутствует")
                );
    }
}