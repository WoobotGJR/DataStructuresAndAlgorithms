package org.woobolt.data_structures.linked_list;

public class ListIterator {
    public LinkedListNode<Integer> current;
    public  LinkedListNode<Integer> previous;
    private final LinkList ourList;

    public ListIterator(LinkList linkList) {
        this.ourList = linkList;
        this.reset();
    }

    public void reset() {
        this.current =  this.ourList.getHead();
        this.previous = null;
    }

    public boolean atEnd() {
        return this.current.next == null;
    }

    public void nextLink() {
        this.previous = this.current;
        this.current = current.next;
    }

    public LinkedListNode<Integer> getCurrent() {
        return this.current;
    }

    public void insertAfter(int key) { // insertion after current element
        LinkedListNode<Integer> listNode = new LinkedListNode<>(key);

        if (this.ourList.isEmpty()) {
            this.ourList.setHead(listNode);
            this.current = listNode;
        } else {
            listNode.next = this.current.next;
            this.current.next = listNode;
            this.nextLink();
        }
    }

    public void insertBefore(int key) { // insertion before current element
        LinkedListNode<Integer> listNode = new LinkedListNode<>(key);

        if (this.previous == null) {
            listNode.next = this.current;
            this.ourList.setHead(listNode);
            this.reset();
        } else {
            listNode.next = this.previous.next;
            this.previous.next = listNode;
            this.current = listNode;
        }
    }

    public int deleteCurrent() {
        int value = current.value;

        if (this.previous == null) {
            this.ourList.setHead(current.next);
            this.reset();
        } else {
            this.previous.next = this.current.next;
            if (this.atEnd()) {
                this.reset();
            } else {
                this.current = this.current.next;
            }
        }
        return value;
    }

}
