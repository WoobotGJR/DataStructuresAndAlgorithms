package org.woobolt.queue;

import org.woobolt.linked_list.DoubleSideLinkedList;

public class LinkedListBasedQueue {
    private DoubleSideLinkedList doubleLinkedList;

    public LinkedListBasedQueue() {
        this.doubleLinkedList = new DoubleSideLinkedList();
    }

    public boolean isEmpty() {
        return this.doubleLinkedList.isEmpty();
    }

    public void insert(int val) {
        this.doubleLinkedList.append(val);
    }

    public int remove() {
        return this.doubleLinkedList.deleteHead();
    }

    public void display() {
        this.doubleLinkedList.display();
    }
}
