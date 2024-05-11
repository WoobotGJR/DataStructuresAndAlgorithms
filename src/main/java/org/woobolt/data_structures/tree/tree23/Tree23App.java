package org.woobolt.data_structures.tree.tree23;

public class Tree23App {
    public static void main(String[] args) {
        Tree23 tree = new Tree23(2);

        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);

        Node result = tree.search(6);
        if (result != null)
            System.out.println("Key found");
        else
            System.out.println("Key not found");
    }
}
