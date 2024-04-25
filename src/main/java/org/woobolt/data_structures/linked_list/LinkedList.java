package org.woobolt.data_structures.linked_list;

public class LinkedList<T> {
	// head is the first element and tail is the last
	LinkedListNode<T> head;

	public LinkedList() {
		this.head = null;
	}

	public void append(T value) {
		LinkedListNode<T> node = new LinkedListNode<>(value);

		if (head == null)
			head = node;
		else {
			LinkedListNode<T> currentNode = head;

			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = node;
		}
	}

	public void prepend(T value) {
		LinkedListNode<T> node = new LinkedListNode<>(value);

		if (head == null)
			head = node;
		else {
			node.next = head;
			head = node;
		}
	}
	
	public void insertAt(T value, int index) {
		LinkedListNode<T> node = new LinkedListNode<>(value);
		
		if (index == 0)
			prepend(value);
		else {
			LinkedListNode<T> currentNode = head;
			
			for(int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			
			node.next = currentNode.next;
			currentNode.next = node;
		}
	}

	public int deleteAt(int index) {
		if (index == 0)
			head = head.next;
		else {
			LinkedListNode<T> currentNode = head;
			LinkedListNode<T> nextNode = null;
			
			for(int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			
			nextNode = currentNode.next;
			currentNode.next = nextNode.next;
			nextNode = null;
			return (int) currentNode.value;
		}
		return -1;
	}

	public LinkedListNode<?> find(int key) {
		LinkedListNode<?> currentNode = head;

		while (!currentNode.value.equals(key)) {
			if (currentNode.next == null) {
				return null;
			} else {
				currentNode = currentNode.next;
			}
		}
		return currentNode;
	}

	public void display() {
		LinkedListNode<T> currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.value + " ");
			currentNode = currentNode.next;
		}
	}

	public boolean isEmpty() {
		return this.head == null;
	}
}
