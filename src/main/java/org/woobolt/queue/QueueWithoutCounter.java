package org.woobolt.queue;

public class QueueWithoutCounter {
    private int maxSize; // максимальный размер очереди
    private int[] queueArray; // массив для хранения элементов очереди
    private int front; // индекс начала очереди
    private int rear; // индекс конца очереди

    // Конструктор для инициализации очереди
    public QueueWithoutCounter(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
    }

    // Метод для добавления элемента в конец очереди
    public void enqueue(int value) {
        // Если очередь полная, выбрасываем исключение
        if (isFull()) {
            throw new IllegalStateException("Очередь переполнена");
        }

        rear = (rear + 1) % maxSize;
        queueArray[rear] = value;
    }

    // Метод для удаления элемента из начала очереди и его возврата
    public int dequeue() {
        // Если очередь пуста, выбрасываем исключение
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста");
        }

        int removedItem = queueArray[front];
        front = (front + 1) % maxSize;
        return removedItem;
    }

    // Метод для получения элемента из начала очереди без его удаления
    public int peek() {
        // Если очередь пуста, выбрасываем исключение
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста");
        }
        return queueArray[front];
    }

    // Метод для проверки, пуста ли очередь
    public boolean isEmpty() {
        return (rear + 1) % maxSize == front;
    }

    // Метод для проверки, заполнена ли очередь
    public boolean isFull() {
        return (rear + 2) % maxSize == front;
    }
}
