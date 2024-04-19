package org.woobolt.stack;

public class Stack {
	private int maxSize;
	private int[] stackArray;
	private int top;
	
	public Stack(int size) {
		this.maxSize = size;
		this.stackArray = new int[size];
		this.top =  -1;
	}
	
	public void push(int value) {
		if (isFull()) {
			System.out.println("Stack us full");
			return;
		}
		stackArray[++top] = value;
	}

	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		
		return stackArray[top--];
	}
	
	public int peek() {
		if(isEmpty()) {
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
}
