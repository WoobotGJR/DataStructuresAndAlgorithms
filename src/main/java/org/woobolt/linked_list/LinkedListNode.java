package org.woobolt.linked_list;

public class LinkedListNode<T> {
	public T value;
	public double doubleValue;
	public LinkedListNode<T> next;


	public LinkedListNode(T value) {
		this.value = value;
		next = null;
	}

	LinkedListNode(T value, double doubleValue) {
		this.value = value;
		this.doubleValue = doubleValue;
		this.next = null;
	}

	public  void displayLink() {
		System.out.println(value.toString() + "%s".formatted(doubleValue));
	}
}
