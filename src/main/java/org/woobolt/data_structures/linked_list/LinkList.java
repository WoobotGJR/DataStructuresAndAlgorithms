package org.woobolt.data_structures.linked_list;

public class LinkList {
    private LinkedListNode head;

    public LinkList() {
        this.head = null;
    }

    public LinkedListNode getHead() {
        return head;
    }

    public void setHead(LinkedListNode head) {
        this.head = head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public ListIterator getIterator() {
        return new ListIterator(this);
    }

    public void display() {
        LinkedListNode current = head;
        while (current != null) {
        current.displayLink();
        current = current.next;
        }
    }
}
