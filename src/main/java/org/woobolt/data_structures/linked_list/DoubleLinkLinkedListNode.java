package org.woobolt.data_structures.linked_list;

public class DoubleLinkLinkedListNode {
    public int value;
    public double doubleValue;
    public DoubleLinkLinkedListNode next;
    public DoubleLinkLinkedListNode previous;


    public DoubleLinkLinkedListNode(int value) {
        this.value = value;
        this.next = null;

    }

    DoubleLinkLinkedListNode(int value, double doubleValue) {
        this.value = value;
        this.doubleValue = doubleValue;
        this.previous = null;
        this.next = null;
    }

    public  void displayLink() {
        System.out.println(value + "%s".formatted(doubleValue));
    }
}
