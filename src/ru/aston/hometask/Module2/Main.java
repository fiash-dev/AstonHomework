package ru.aston.hometask.Module2;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        final Validation validation= new Validation();
        final JsonParser jasonParser = new JsonParser();

        System.out.print("Введите путь к JSON‑файлу со студентами: ");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine().trim();

        if (!validation.isValidation(filePath)) {
            scanner.close();
        }
        List<Student> students = jasonParser.loadStudentsFromJson(filePath);



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