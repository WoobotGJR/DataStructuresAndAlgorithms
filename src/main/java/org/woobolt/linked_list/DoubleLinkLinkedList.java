package org.woobolt.linked_list;

public class DoubleLinkLinkedList {
    public DoubleLinkLinkedListNode head;
    public DoubleLinkLinkedListNode tail;

    public boolean isEmpty() {
        return this.head == null;
    }

    public void insertHead(int key) {
    var node = new DoubleLinkLinkedListNode(key);

    if (this.isEmpty())
        this.tail = node;
    else
        this.head.previous = node;
    node.next = this.head;
    this.head = node;
    }

    public void insertTail(int key) {
        var node = new DoubleLinkLinkedListNode(key);

        if (this.isEmpty())
            this.head = node;
        else {
            this.tail.next = node;
            node.previous = tail;
        }
        this.tail = node;
    }

    public DoubleLinkLinkedListNode deleteHead() {
        var temp = this.head;
        if (head.next == null)
            head = null;
        else
            this.head.next.previous = null; // making the new head element previous element link null
        assert this.head != null;
        this.head = this.head.next;
        return temp;
    }

    public DoubleLinkLinkedListNode deleteTail() {
        var temp = this.tail;
        if (head.next == null)
            head = null;
        else
            this.tail.previous.next = null; // making the new tail element next element link null
        this.tail = this.tail.previous;
        return temp;
    }

    public boolean insertAfter(int key, int value) {
        var current = this.head;

        while (current.value != key) {
            current = current.next;
            if (current == null)
                return false;
        }
        var newNode = new DoubleLinkLinkedListNode(value);

        if (current == this.tail) {
            newNode.next = null;
            this.tail = newNode;
        } else {
            newNode.next = current.next;
            current.next.previous = newNode;
        }
        newNode.previous = current;
        current.next = newNode;
        return true;
    }

    public DoubleLinkLinkedListNode deleteKey(int key) {
        var current = this.head;

        while (current.value != key) {
            current = current.next;
            if (current == null)
                return null;
        }

        if (current == this.head) {
            this.head = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current == this.tail) {
            this.tail = current.previous;
        } else {
            current.next.previous = current.previous;
        }

        return current;
    }

    public void displayForward() {
        var current = this.head;

        while (current != null) {
            current.displayLink();
            current = current.next;
            System.out.println();
        }
    }

    public void displayBackward() {
        var current = this.tail;

        while (current != null) {
            current.displayLink();
            current = current.previous;
            System.out.println();
        }
    }
}
