package org.woobolt.data_structures.tree.tree234.tree234second;

class Tree234 {
    Node root;
    int t; // минимальная степень дерева

    Tree234(int t) {
        this.root = null;
        this.t = t;
    }

    // Метод для поиска ключа в дереве
    Node search(int key) {
        return (root == null) ? null : root.search(key);
    }

    // Метод для вставки ключа в дерево
    void insert(int key) {
        if (root == null) {
            root = new Node(t, true);
            root.keys[0] = key;
            root.numKeys = 1;
        } else {
            if (root.numKeys == 2 * t - 1) {
                Node s = new Node(t, false);
                s.children[0] = root;
                s.splitChild(0, root, t);
                int i = 0;
                if (s.keys[0] < key)
                    i++;
                s.children[i].insertNonFull(key, t);
                root = s;
            } else {
                root.insertNonFull(key, t);
            }
        }
    }
}