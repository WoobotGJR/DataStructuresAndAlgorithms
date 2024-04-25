package org.woobolt.data_structures.linked_list;

public class DoubleSideLinkedList {
    private LinkedListNode<Integer> head;
    private LinkedListNode<Integer> tail;

    public DoubleSideLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void append(int value) {
        LinkedListNode<Integer> node = new LinkedListNode<>(value);

        if (this.isEmpty())
            this.tail = node;

        node.next = head;
        this.head = node;
    }

    public void prepend(int value) {
        LinkedListNode<Integer> node = new LinkedListNode<>(value);

        if (this.isEmpty())
            this.head = node;

        this.tail.next = node;
        this.tail = node;
    }

    public int deleteHead() {
        int temp = (int) head.value;

        if (head.next == null) {
            this.tail = null;
        }

        this.head = this.head.next;

        return temp;
    }

    public void display() {
        LinkedListNode<Integer> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
    }
}
