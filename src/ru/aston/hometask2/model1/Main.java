package ru.aston.hometask2.model1;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        System.out.println("Добавление элементов:");
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        System.out.println("size = " + map.size());

        System.out.println();
        System.out.println("Замена значения по существующему ключу:");
        Integer old = map.put("two", 22);
        System.out.println("Старое значение для key=\"two\": " + old +
                "\n Новое значение для key=\"two\": " + map.get("two") +
                "\n size = " + map.size());

        System.out.println();
        System.out.println("Получение значений:" +
                "\n key=\"one\"   -> " + map.get("one") +
                "\n key=\"two\"   -> " + map.get("two") +
                "\n key=\"four\"  -> " + map.get("four"));

        System.out.println();
        System.out.println("Удаление элементов:");
        Integer removed = map.remove("three");
        System.out.println("Удалено значение по key=\"three\": " + removed +
                "\n size = " + map.size() +
                "\n get(\"three\") -> " + map.get("three"));

        System.out.println();
        System.out.println("Работа с null ключом:");
        map.put(null, 100);
        System.out.println("get(null) = " + map.get(null));
        map.remove(null);
        System.out.println("get(null) после remove = " + map.get(null));

        System.out.println();
        System.out.println("Очистка:");
        map.clear();
        System.out.println("size после clear = " + map.size());
    }
}
