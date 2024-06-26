package org.woobolt.data_structures.tree.tree234.tree234second;

public class Tree234App {
    public static void main(String[] args) {
        Tree234 tree = new Tree234(3);

        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);

        Node result = tree.search(6);
        if (result != null) {
            System.out.println("Key found");
            result.displayNode();
        }
        else
            System.out.println("Key not found");
    }
}
