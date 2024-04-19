package org.woobolt.stack;

public class DynamicStack {
	private int maxSize;
	private int[] stackArray;
	private int top;

	public DynamicStack(int size) {
		this.maxSize = size;
		this.stackArray = new int[size];
		this.top = -1;
	}

	public void push(int value) {
		if (isFull()) {
			expandStack();
		}
		stackArray[++top] = value;
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}

		shrink();
		return stackArray[top--];
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}

		return stackArray[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	private void expandStack() {
		int newMaxSize = maxSize * 2;
		int[] newStackArray = new int[newMaxSize];
		
//		for (int i = 0; i <= top; i++) {
//            newStackArray[i] = stackArray[i];
//        }
		
		System.arraycopy(stackArray, 0, newStackArray, 0, newMaxSize);
		
		stackArray = newStackArray;
		maxSize = newMaxSize;
	}
	
	private void shrink() {
        if (top < maxSize / 4) { // Если заполненность стека упала ниже четверти его размера
            int newMaxSize = maxSize / 2; // Уменьшаем размер вдвое
            int[] newStackArray = new int[newMaxSize];
            for (int i = 0; i <= top; i++) {
                newStackArray[i] = stackArray[i];
            }
            stackArray = newStackArray; // Обновляем ссылку на массив стека
            maxSize = newMaxSize; // Обновляем максимальный размер стека
        }
    }
}
