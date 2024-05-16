package org.woobolt.data_structures.hashtable.universalhashing;

import java.util.Random;

public class UniversalHashing {
    private int capacity;
    private int size;
    private Entry[] table;
    private UniversalHashFunction[] hashFunctions;
    private Random random;

    // Внутренний класс для представления элемента в хеш-таблице
    private static class Entry {
        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // Внутренний класс для представления универсальной хеш-функции
    private interface UniversalHashFunction {
        int hash(int key);
    }

    public UniversalHashing(int capacity, int numHashFunctions) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new Entry[capacity];
        this.hashFunctions = new UniversalHashFunction[numHashFunctions];
        this.random = new Random();

        // Генерация универсальных хеш-функций
        for (int i = 0; i < numHashFunctions; i++) {
            hashFunctions[i] = new UniversalHashFunction() {
                int a = random.nextInt(capacity - 1) + 1;
                int b = random.nextInt(capacity);

                @Override
                public int hash(int key) {
                    return ((a * key + b) % capacity);
                }
            };
        }
    }

    // Метод для вставки элемента в хеш-таблицу
    public void put(int key, String value) {
        if (size == capacity) {
            System.out.println("Хеш-таблица заполнена");
            return;
        }

        for (UniversalHashFunction hashFunction : hashFunctions) {
            int index = hashFunction.hash(key);
            if (table[index] == null) {
                table[index] = new Entry(key, value);
                size++;
                return;
            }
        }

        // Если все индексы, вычисленные с помощью хеш-функций, заняты, выходим
        System.out.println("Не удалось вставить элемент. Все индексы заняты.");
    }

    // Метод для получения значения по ключу
    public String get(int key) {
        for (UniversalHashFunction hashFunction : hashFunctions) {
            int index = hashFunction.hash(key);
            if (table[index] != null && table[index].key == key) {
                return table[index].value;
            }
        }
        return null; // Ключ не найден
    }

    // Метод для удаления элемента по ключу
    public void remove(int key) {
        for (UniversalHashFunction hashFunction : hashFunctions) {
            int index = hashFunction.hash(key);
            if (table[index] != null && table[index].key == key) {
                table[index] = null;
                size--;
                return;
            }
        }
        // Если ключ не найден, выводим сообщение
        System.out.println("Элемент с ключом " + key + " не найден.");
    }

    // Метод для проверки, пуста ли хеш-таблица
    public boolean isEmpty() {
        return size == 0;
    }

    // Метод для вывода содержимого хеш-таблицы
    public void display() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                System.out.println("Index " + i + ": Key = " + table[i].key + ", Value = " + table[i].value);
            }
        }
    }
}