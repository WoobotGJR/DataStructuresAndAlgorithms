package org.woobolt.data_structures.heap.heaptree;

import org.woobolt.data_structures.tree.RBTree.RedBlackTree;
import org.woobolt.data_structures.tree.RBTree.Node;

// Создаем класс MinHeap на базе красно-черного дерева
public class HeapTree {
    private RedBlackTree tree;

    public HeapTree() {
        this.tree = new RedBlackTree();
    }

    // Метод для вставки нового элемента в пирамиду
    public void insert(int data) {
        tree.insert(data);
    }

    // Метод для извлечения минимального элемента из пирамиды
    public int extractMin() {
        if (tree.root == null) {
            throw new IllegalStateException("Heap is empty");
        }
        Node minNode = findMin(tree.root);
        int minValue = minNode.data;
        deleteNode(minNode);
        return minValue;
    }

    // Метод для получения минимального элемента без его удаления
    public int getMin() {
        if (tree.root == null) {
            throw new IllegalStateException("Heap is empty");
        }
        Node minNode = findMin(tree.root);
        return minNode.data;
    }

    // Вспомогательный метод для поиска минимального узла в дереве
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Метод для удаления узла из дерева
    private void deleteNode(Node node) {
        // Удаление узла из красно-черного дерева и восстановление свойств дерева
        tree.deleteNode(node);
    }


}
