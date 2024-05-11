package org.woobolt.data_structures.tree.btree;

class BTree {
    private Node root;
    private int t;

    public BTree(int t) {
        this.t = t;
        root = new Node(t, true);
    }

    public void insert(int k) {
        if (root.keys.size() == 2 * t - 1) {
            Node s = new Node(t, false);
            s.children.add(root);
            s.splitChild(0, root);
            int i = 0;
            if (s.keys.get(0) < k)
                ++i;
            s.children.get(i).insertNonFull(k);
            root = s;
        } else
            root.insertNonFull(k);
    }

    public void traverse() {
        if (root != null)
            root.traverse();
    }
}
