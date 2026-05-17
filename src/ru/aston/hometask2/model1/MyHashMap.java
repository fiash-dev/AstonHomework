package ru.aston.hometask2.model1;

public class MyHashMap<K, V> {

    static class Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Entry<K, V> next;

        Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Entry<K, V>[] table;
    private int size;
    private int threshold;
    private final float loadFactor;

    @SuppressWarnings("unchecked")
    public MyHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }
        if (initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        }
        this.loadFactor = loadFactor;

        int capacity = tableSizeFor(initialCapacity);
        this.threshold = (int) (capacity * loadFactor);
        this.table = (Entry<K, V>[]) new Entry[capacity];
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V put(K key, V value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);

        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            if (e.hash == hash && keysEqual(e.key, key)) {
                V old = e.value;
                e.value = value;
                return old;
            }
        }

        addEntry(hash, key, value, index);
        return null;
    }

    public V get(K key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);

        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            if (e.hash == hash && keysEqual(e.key, key)) {
                return e.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);

        Entry<K, V> prev = null;
        Entry<K, V> e = table[index];

        while (e != null) {
            Entry<K, V> next = e.next;
            if (e.hash == hash && keysEqual(e.key, key)) {
                if (prev == null) {
                    table[index] = next;
                } else {
                    prev.next = next;
                }
                size--;
                return e.value;
            }
            prev = e;
            e = next;
        }
        return null;
    }

    public void clear() {
        Entry<K, V>[] tab = table;
        for (int i = 0; i < tab.length; i++) {
            tab[i] = null;
        }
        size = 0;
    }

    private static int hash(Object key) {
        int h;
        if (key == null) {
            return 0;
        }
        h = key.hashCode();
        return h ^ (h >>> 16);
    }

    private static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    private static boolean keysEqual(Object k1, Object k2) {
        if (k1 == k2) {
            return true;
        }
        if (k1 == null || k2 == null) {
            return false;
        }
        return k1.equals(k2);
    }

    private static int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    private void addEntry(int hash, K key, V value, int bucketIndex) {
        Entry<K, V> e = table[bucketIndex];
        table[bucketIndex] = new Entry<>(hash, key, value, e);
        size++;
        if (size > threshold) {
            resize(2 * table.length);
        }
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        int capacity = tableSizeFor(newCapacity);
        Entry<K, V>[] oldTable = table;
        Entry<K, V>[] newTable = (Entry<K, V>[]) new Entry[capacity];

        for (int i = 0; i < oldTable.length; i++) {
            Entry<K, V> e = oldTable[i];
            if (e != null) {
                oldTable[i] = null;
                while (e != null) {
                    Entry<K, V> next = e.next;
                    int newIndex = indexFor(e.hash, capacity);
                    e.next = newTable[newIndex];
                    newTable[newIndex] = e;
                    e = next;
                }
            }
        }

        table = newTable;
        threshold = (int) (capacity * loadFactor);
    }
}