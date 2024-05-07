package org.woobolt.data_structures.binary_tree.RBTree;

public class RedBlackTreeTest {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        // Вставляем элементы в дерево
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(15);
        tree.insert(25);
        tree.insert(5);
        tree.insert(35);

        // Выводим дерево в консоль
        System.out.println("Дерево:");
        tree.printTree();
    }
}