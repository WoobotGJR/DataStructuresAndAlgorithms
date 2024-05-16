package org.woobolt.data_structures.hashtable.chainmethod;

import java.util.LinkedList;

public class ChainMethod {
    private int capacity;
    private LinkedList<Entry>[] table;

    // Внутренний класс для представления элемента в цепочке
    private static class Entry {
        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public ChainMethod(int capacity) {
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Метод для вычисления хеша ключа
    private int hash(int key) {
        return key % capacity;
    }

    // Метод для вставки элемента в хеш-таблицу
    public void put(int key, String value) {
        int index = hash(key);
        LinkedList<Entry> list = table[index];
        for (Entry entry : list) {
            if (entry.key == key) {
                entry.value = value; // Если ключ уже существует, обновляем значение
                return;
            }
        }
        list.add(new Entry(key, value)); // Добавляем новую пару ключ-значение в цепочку
    }

    // Метод для получения значения по ключу
    public String get(int key) {
        int index = hash(key);
        LinkedList<Entry> list = table[index];
        for (Entry entry : list) {
            if (entry.key == key) {
                return entry.value; // Возвращаем значение, если ключ найден
            }
        }
        return null; // Возвращаем null, если ключ не найден
    }

    // Метод для удаления элемента по ключу
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Entry> list = table[index];
        list.removeIf(entry -> entry.key == key); // Удаляем элемент из цепочки, если ключ найден
    }

    // Метод для проверки, пуста ли хеш-таблица
    public boolean isEmpty() {
        for (LinkedList<Entry> list : table) {
            if (!list.isEmpty()) {
                return false; // Если хотя бы одна цепочка не пуста, возвращаем false
            }
        }
        return true; // Возвращаем true, если все цепочки пусты
    }

    // Метод для проверки, содержится ли ключ в хеш-таблице
    public boolean containsKey(int key) {
        int index = hash(key);
        LinkedList<Entry> list = table[index];
        for (Entry entry : list) {
            if (entry.key == key) {
                return true; // Если ключ найден, возвращаем true
            }
        }
        return false; // Если ключ не найден, возвращаем false
    }

    // Метод для вывода содержимого хеш-таблицы
    public void display() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            LinkedList<Entry> list = table[i];
            for (Entry entry : list) {
                System.out.print("(" + entry.key + ", " + entry.value + ") ");
            }
            System.out.println();
        }
    }
}