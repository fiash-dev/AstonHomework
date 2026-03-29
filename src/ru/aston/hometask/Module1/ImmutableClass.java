package ru.aston.hometask.Module1;

import java.util.HashMap;
import java.util.Map;

public final class ImmutableClass {
    private final long id;
    private final String name;
    private final Map<Integer, String> map;

    public ImmutableClass(int id, String name, Map<Integer, String> map) {
        this.id = id;
        this.name = name;
        this.map = copyMap(map);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, String> getMap() {
        return copyMap(map);
    }

    private Map<Integer, String> copyMap(Map<Integer, String> original) {
        return original == null ? new HashMap<>() : new HashMap<>(original);
    }

    @Override
    public String toString() {
        return "Неизменяемая запись (" + "ID: " + id +
                ", Имя: '" + name + '\'' +
                ", map: " + map +
                ')';
    }
}
