package org.woobolt.data_structures.hashtable.rbtreehash;

import java.util.TreeMap;

public class RBTreeHash {
    private int capacity;
    private TreeMap<Integer, String>[] buckets;

    public RBTreeHash(int capacity) {
        this.capacity = capacity;
        this.buckets = new TreeMap[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new TreeMap<>();
        }
    }

    // Метод для вычисления хеша ключа
    private int hash(int key) {
        return key % capacity;
    }

    // Метод для вставки элемента в хеш-таблицу
    public void put(int key, String value) {
        int index = hash(key);
        buckets[index].put(key, value);
    }

    // Метод для получения значения по ключу
    public String get(int key) {
        int index = hash(key);
        return buckets[index].get(key);
    }

    // Метод для удаления элемента по ключу
    public void remove(int key) {
        int index = hash(key);
        buckets[index].remove(key);
    }

    // Метод для проверки, пуста ли хеш-таблица
    public boolean isEmpty() {
        for (TreeMap<Integer, String> bucket : buckets) {
            if (!bucket.isEmpty()) {
                return false; // Если хотя бы один bucket не пуст, возвращаем false
            }
        }
        return true; // Возвращаем true, если все buckets пусты
    }

    // Метод для проверки, содержится ли ключ в хеш-таблице
    public boolean containsKey(int key) {
        int index = hash(key);
        return buckets[index].containsKey(key);
    }

    // Метод для вывода содержимого хеш-таблицы
    public void display() {
        for (int i = 0; i < capacity; i++) {
            if (!buckets[i].isEmpty()) {
                System.out.println("Bucket " + i + ": " + buckets[i]);
            }
        }
    }
}