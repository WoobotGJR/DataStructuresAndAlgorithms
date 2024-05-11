package org.woobolt.data_structures.tree.btree;

import java.util.ArrayList;

class Node {
    ArrayList<Integer> keys;
    int t;
    ArrayList<Node> children;
    boolean leaf;

    public Node(int t, boolean leaf) {
        this.t = t;
        this.leaf = leaf;
        keys = new ArrayList<>();
        children = new ArrayList<>();
    }

    int findKey(int k) {
        int idx = 0;
        while (idx < keys.size() && keys.get(idx) < k)
            ++idx;
        return idx;
    }

    void insertNonFull(int k) {
        int i = keys.size() - 1;

        if (leaf) {
            while (i >= 0 && keys.get(i) > k)
                --i;
            keys.add(i + 1, k);
        } else {
            while (i >= 0 && keys.get(i) > k)
                --i;
            int childIdx = i + 1;
            if (children.get(childIdx).keys.size() == 2 * t - 1) {
                splitChild(childIdx, children.get(childIdx));
                if (keys.get(childIdx) < k)
                    ++childIdx;
            }
            children.get(childIdx).insertNonFull(k);
        }
    }

    void splitChild(int i, Node y) {
        Node z = new Node(y.t, y.leaf);
        z.keys = new ArrayList<>(y.keys.subList(t, 2 * t - 1));
        if (!y.leaf) {
            z.children = new ArrayList<>(y.children.subList(t, 2 * t));
            y.children.subList(t, 2 * t).clear();
        }
        y.keys.subList(t, 2 * t - 1).clear();

        children.add(i + 1, z);
        keys.add(i, y.keys.get(t - 1));
    }

    void traverse() {
        int i;
        for (i = 0; i < keys.size(); i++) {
            if (!leaf)
                children.get(i).traverse();
            System.out.print(keys.get(i) + " ");
        }
        if (!leaf)
            children.get(i).traverse();
    }
}