package org.woobolt.algorithms;

import org.woobolt.linked_list.LinkedListNode;
import org.woobolt.linked_list.SortedLinkedList;

import java.util.stream.Stream;

public class ListInsertionSort {

    SortedLinkedList sortedLinkedList;

    public ListInsertionSort(LinkedListNode<Integer>[] linkedListNodes) {
        this.sortedLinkedList = new SortedLinkedList();

        Stream.of(linkedListNodes)
                .forEach(node -> sortedLinkedList.insert(node.value));
    }

    public void setValue(int key) {
        LinkedListNode<Integer> listNode = new LinkedListNode<>(key);
        this.sortedLinkedList.insert(listNode.value);
    }

    public SortedLinkedList getSortedList() {
        return sortedLinkedList;
    }
}
