package org.woobolt.data_structures.queue;

class DynamicQueue {
    private int maxSize; // максимальный размер очереди
    private int[] queueArray; // массив для хранения элементов очереди
    private int front; // индекс начала очереди
    private int rear; // индекс конца очереди
    private int currentSize; // текущее количество элементов в очереди

    // Конструктор для инициализации очереди
    public DynamicQueue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    // Метод для добавления элемента в конец очереди
    public void enqueue(int value) {
        if (isFull()) {
            expandQueue(); // Расширяем очередь, если она полна
        }
		/*
		 * Фактически, в случае, когда rear достигает конца массива, нам не обязательно
		 * возвращаться в начало массива, чтобы продолжать добавлять элементы.
		 * 
		 * Очередь в кольцевом массиве действует подобно циклической очереди, где
		 * элементы добавляются в конец и извлекаются из начала. Когда rear достигает
		 * конца массива, мы можем просто перенаправить его на начало массива.
		 * 
		 * Таким образом, операция (rear + 1) % maxSize возвращает индекс следующего
		 * элемента в циклическом массиве. Если rear указывает на последний элемент
		 * массива (т.е. rear == maxSize - 1), (rear + 1) % maxSize вернет 0, что
		 * означает, что мы переходим к началу массива, создавая циклическую структуру
		 * данных.
		 * 
		 * Такой подход обеспечивает эффективное использование памяти и позволяет нам
		 * избежать переполнения массива при добавлении новых элементов в очередь.
		 */        
        rear = (rear + 1) % maxSize;
        queueArray[rear] = value;
        currentSize++;
    }

    // Метод для удаления элемента из начала очереди и его возврата
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Очередь пуста");
            return -1;
        }
        int removedItem = queueArray[front];
        front = (front + 1) % maxSize;
        currentSize--;
        return removedItem;
    }

    // Метод для получения элемента из начала очереди без его удаления
    public int peek() {
        if (isEmpty()) {
            System.out.println("Очередь пуста");
            return -1;
        }
        return queueArray[front];
    }

    // Метод для проверки, пуста ли очередь
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Метод для проверки, заполнена ли очередь
    public boolean isFull() {
        return currentSize == maxSize;
    }

    // Метод для увеличения размера очереди
    private void expandQueue() {
        int newSize = maxSize * 2; // Увеличиваем размер вдвое
        int[] newQueueArray = new int[newSize];
        // Копируем элементы из старой очереди в новую
        for (int i = 0; i < currentSize; i++) {
            newQueueArray[i] = queueArray[(front + i) % maxSize];
        }
        queueArray = newQueueArray;
        maxSize = newSize;
        front = 0;
        rear = currentSize - 1;
    }
}
