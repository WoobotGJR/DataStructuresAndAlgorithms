package org.woobolt.data_structures.hashtable.openadressing.quadritic;

public class Quadritic {
    private int capacity;
    private int size;
    private int[] keys;
    private String[] values;

    public Quadritic(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.keys = new int[capacity];
        this.values = new String[capacity];
    }

    // Метод для вычисления хеша ключа
    private int hash(int key) {
        return key % capacity;
    }

    // Метод для вставки элемента в хеш-таблицу
    public void put(int key, String value) {
        if (size == capacity) {
            System.out.println("Хеш-таблица заполнена");
            return;
        }

        int index = hash(key);
        int offset = 1;
        while (keys[index] != 0) {
            index = (index + offset * offset) % capacity;
            offset++;
        }

        keys[index] = key;
        values[index] = value;
        size++;
    }

    // Метод для получения значения по ключу
    public String get(int key) {
        int index = hash(key);
        int offset = 1;
        while (keys[index] != key) {
            index = (index + offset * offset) % capacity;
            offset++;
            if (keys[index] == 0 || offset > capacity) {
                return null; // Ключ не найден
            }
        }
        return values[index];
    }

    // Метод для удаления элемента по ключу
    public void remove(int key) {
        int index = hash(key);
        int offset = 1;
        while (keys[index] != key) {
            index = (index + offset * offset) % capacity;
            offset++;
            if (keys[index] == 0 || offset > capacity) {
                return; // Ключ не найден
            }
        }
        keys[index] = 0;
        values[index] = null;
        size--;
    }

    // Метод для проверки, пуста ли хеш-таблица
    public boolean isEmpty() {
        return size == 0;
    }

    // Метод для проверки, содержится ли ключ в хеш-таблице
    public boolean containsKey(int key) {
        int index = hash(key);
        int offset = 1;
        while (keys[index] != key) {
            index = (index + offset * offset) % capacity;
            offset++;
            if (keys[index] == 0 || offset > capacity) {
                return false; // Ключ не найден
            }
        }
        return true;
    }

    // Метод для вывода содержимого хеш-таблицы
    public void display() {
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != 0) {
                System.out.println("Key: " + keys[i] + ", Value: " + values[i]);
            }
        }
    }
}