package org.woobolt.data_structures.tree.btree;

public class BTreeApp {
    public static void main(String[] args) {
        BTree tree = new BTree(3);

        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        tree.insert(30);
        tree.insert(7);
        tree.insert(17);

        System.out.println("Traversal of the constructed B-tree is:");
        tree.traverse();
    }
}
