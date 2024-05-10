package org.woobolt.data_structures.tree.RBTree;

class Node {
    int data; // Значение узла
    Node parent; // Родительский узел
    Node left; // Левый дочерний узел
    Node right; // Правый дочерний узел
    int color; // Цвет узла (0 - черный, 1 - красный)

    // Конструктор для создания нового узла
    public Node(int data) {
        this.data = data;
        parent = null;
        left = null;
        right = null;
        this.color = 1; // При вставке нового узла он всегда красный
    }
}