package org.woobolt.data_structures.tree.tree234.tree234second;

class Node {
    int[] keys;
    Node[] children;
    int numKeys;
    boolean isLeaf;

    // Конструктор для создания нового узла
    Node(int t, boolean leaf) {
        this.numKeys = 0;
        this.isLeaf = leaf;
        this.keys = new int[2 * t - 1];
        this.children = new Node[2 * t];
    }

    // Метод для поиска ключа в поддереве, начиная с этого узла
    Node search(int key) {
        int i = 0;
        while (i < numKeys && key > keys[i])
            i++;
        if (i < numKeys && keys[i] == key)
            return this;
        if (isLeaf)
            return null;
        return children[i].search(key);
    }

    // Метод для вставки нового ключа в поддерево, начиная с этого узла
    void insertNonFull(int key, int t) {
        int i = numKeys - 1;
        if (isLeaf) {
            while (i >= 0 && keys[i] > key) {
                keys[i + 1] = keys[i];
                i--;
            }
            keys[i + 1] = key;
            numKeys++;
        } else {
            while (i >= 0 && keys[i] > key)
                i--;
            if (children[i + 1].numKeys == 2 * t - 1) {
                splitChild(i + 1, children[i + 1], t);
                if (keys[i + 1] < key)
                    i++;
            }
            children[i + 1].insertNonFull(key, t);
        }
    }

    // Метод для разделения дочернего узла данного узла
    void splitChild(int i, Node y, int t) {
        Node z = new Node(t, y.isLeaf);
        z.numKeys = t - 1;
        for (int j = 0; j < t - 1; j++)
            z.keys[j] = y.keys[j + t];
        if (!y.isLeaf) {
            for (int j = 0; j < t; j++)
                z.children[j] = y.children[j + t];
        }
        y.numKeys = t - 1;
        for (int j = numKeys; j >= i + 1; j--)
            children[j + 1] = children[j];
        children[i + 1] = z;
        for (int j = numKeys - 1; j >= i; j--)
            keys[j + 1] = keys[j];
        keys[i] = y.keys[t - 1];
        numKeys++;
    }

    void displayNode() {
        for (int i = 0; i < numKeys; i++) {
            System.out.print(keys[i] + " ");
        }
        System.out.println();
    }
}