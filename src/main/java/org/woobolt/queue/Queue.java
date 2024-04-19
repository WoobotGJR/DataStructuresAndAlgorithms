package org.woobolt.queue;

class Queue {
	private int maxSize; // максимальный размер очереди
	private int[] queueArray; // массив для хранения элементов очереди
	private int front; // индекс начала очереди
	private int rear; // индекс конца очереди
	private int currentSize; // текущее количество элементов в очереди

	// Конструктор для инициализации очереди
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		queueArray = new int[maxSize];
		front = 0;
		rear = -1;
		currentSize = 0;
	}

	// Метод для добавления элемента в конец очереди
	public void enqueue(int value) {
		if (isFull()) {
			System.out.println("Очередь переполнена");
			return;
		}

		// когда rear достигает конца массива, он оборачивается к началу массива, чтобы обеспечить кольцевую структуру,
		// и это происходит с помощью операции % maxSize.
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

	// Метод для получения текущего количества элементов в очереди
	public int size() {
		return currentSize;
	}
}
