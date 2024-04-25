package org.woobolt.data_structures.stack;

import org.woobolt.data_structures.linked_list.LinkedList;

public class LinkedListBasedStack {
    private LinkedList<Integer> linkedList;

    public LinkedListBasedStack() {
        this.linkedList = new LinkedList<>();
    }

    public void push(int val) {
        this.linkedList.append(val);
    }

    public int pop() {
        return this.linkedList.deleteAt(0);
    }

    public boolean isEmpty() {
        return this.linkedList.isEmpty();
    }

    public void display() {
        this.linkedList.display();
    }
}
