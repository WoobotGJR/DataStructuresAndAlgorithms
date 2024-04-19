package org.woobolt.linked_list;

public class SortedLinkedList {
    private LinkedListNode<Integer> head;

    public SortedLinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void insert(int key) {
        LinkedListNode<Integer> listNode = new LinkedListNode<>(key);
        LinkedListNode<Integer> previous = null;
        LinkedListNode<Integer> current = this.head;

        while (current != null && key > current.value) {
            previous = current;
            current = current.next;
        }
        if (previous == null)
            this.head = listNode;
        else
            previous.next = listNode;
        listNode.next = current;
    }

    public LinkedListNode<?> removeHead() {
        LinkedListNode<Integer> temp = this.head;
        this.head = this.head.next;
        return temp;
    }

    public void display() {
        LinkedListNode<?> current = head;

        while (current != null) {
            current.displayLink();
            current = current.next;
            System.out.println();
        }
    }
}
