package org.woobolt.data_structures.binary_tree.RBTree;

// Создаем класс узла дерева


// Создаем класс красно-черного дерева
public class RedBlackTree {
    Node root; // Корневой узел дерева

    // Конструктор для создания пустого дерева
    public RedBlackTree() {
        root = null;
    }

    // Вставка нового узла в дерево
    public void insert(int data) {
        Node newNode = new Node(data); // Создаем новый узел
        if (root == null) {
            root = newNode; // Если дерево пустое, новый узел становится корнем
            root.color = 0; // Корень всегда черный
        } else {
            // Рекурсивная вставка нового узла
            insertRecursive(root, newNode);
            fixViolations(newNode); // Проверяем и исправляем нарушения свойств красно-черного дерева
            this.printTree();
        }
    }

    // Рекурсивная вставка нового узла
    private void insertRecursive(Node root, Node newNode) {
        if (newNode.data < root.data) {
            if (root.left == null) {
                root.left = newNode;
                newNode.parent = root;
            } else {
                insertRecursive(root.left, newNode);
            }
        } else if (newNode.data > root.data) {
            if (root.right == null) {
                root.right = newNode;
                newNode.parent = root;
            } else {
                insertRecursive(root.right, newNode);
            }
        }
    }

    // Метод для проверки и исправления нарушений свойств красно-черного дерева
    private void fixViolations(Node newNode) {
        Node parent = null;
        Node grandparent = null;
        while (newNode != root && newNode.color == 1 && newNode.parent.color == 1) {
            parent = newNode.parent;
            grandparent = parent.parent;
            // Случай 1: Родитель узла newNode является левым дочерним узлом своего родителя
            if (parent == grandparent.left) {
                Node uncle = grandparent.right; // Дядя newNode
                // Подслучай 1: Дядя newNode является красным
                if (uncle != null && uncle.color == 1) {
                    grandparent.color = 1; // Перекрашиваем дедушку в красный
                    parent.color = 0; // Перекрашиваем родителя в черный
                    uncle.color = 0; // Перекрашиваем дядю в черный
                    newNode = grandparent; // Перемещаем указатель на дедушку и повторяем проверку
                } else {
                    // Подслучай 2: Дядя newNode является черным или отсутствует
                    if (newNode == parent.right) {
                        rotateLeft(parent); // Выполняем левый поворот
                        newNode = parent;
                        parent = newNode.parent;
                    }
                    rotateRight(grandparent); // Выполняем правый поворот
                    int temp = parent.color;
                    parent.color = grandparent.color;
                    grandparent.color = temp;
                    newNode = parent;
                }
            }
            // Случай 2: Родитель узла newNode является правым дочерним узлом своего родителя
            else {
                Node uncle = grandparent.left; // Дядя newNode
                // Подслучай 1: Дядя newNode является красным
                if (uncle != null && uncle.color == 1) {
                    grandparent.color = 1; // Перекрашиваем дедушку в красный
                    parent.color = 0; // Перекрашиваем родителя в черный
                    uncle.color = 0; // Перекрашиваем дядю в черный
                    newNode = grandparent; // Перемещаем указатель на дедушку и повторяем проверку
                } else {
                    // Подслучай 2: Дядя newNode является черным или отсутствует
                    if (newNode == parent.left) {
                        rotateRight(parent); // Выполняем правый поворот
                        newNode = parent;
                        parent = newNode.parent;
                    }
                    rotateLeft(grandparent); // Выполняем левый поворот
                    int temp = parent.color;
                    parent.color = grandparent.color;
                    grandparent.color = temp;
                    newNode = parent;
                }
            }
        }
        root.color = 0; // Корень всегда черный
    }

    // Метод для выполнения левого поворота вокруг узла x
    private void rotateLeft(Node x) {
        Node y = x.right; // y становится правым дочерним узлом x
        x.right = y.left; // Поддерево y.left становится правым поддеревом x
        if (y.left != null) {
            y.left.parent = x; // Устанавливаем связь между y.left и x
        }
        y.parent = x.parent; // Родитель x становится родителем y
        if (x.parent == null) {
            root = y; // Если x является корнем, y становится новым корнем
        } else if (x == x.parent.left) {
            x.parent.left = y; // Если x является левым дочерним узлом, y становится новым левым дочерним узлом родителя x
        } else {
            x.parent.right = y; // Если x является правым дочерним узлом, y становится новым правым дочерним узлом родителя x
        }
        y.left = x; // x становится левым дочерним узлом y
        x.parent = y; // y становится родителем x
    }

    // Метод для выполнения правого поворота вокруг узла x
    private void rotateRight(Node x) {
        Node y = x.left; // y становится левым дочерним узлом x
        x.left = y.right; // Поддерево y.right становится левым поддеревом x
        if (y.right != null) {
            y.right.parent = x; // Устанавливаем связь между y.right и x
        }
        y.parent = x.parent; // Родитель x становится родителем y
        if (x.parent == null) {
            root = y; // Если x является корнем, y становится новым корнем
        } else if (x == x.parent.right) {
            x.parent.right = y; // Если x является правым дочерним узлом, y становится новым правым дочерним узлом родителя x
        } else {
            x.parent.left = y; // Если x является левым дочерним узлом, y становится новым левым дочерним узлом родителя x
        }
        y.right = x; // x становится правым дочерним узлом y
        x.parent = y; // y становится родителем x
    }

    public void printTree() {
        printTree(root, "", true);
    }

    // Рекурсивный метод для вывода поддерева в консоли
    private void printTree(Node node, String indent, boolean isLast) {
        if (node != null) {
            System.out.print(indent);
            if (isLast) {
                System.out.print("└── ");
                indent += "    ";
            } else {
                System.out.print("├── ");
                indent += "│   ";
            }
            System.out.println(node.data + " (" + (node.color == 0 ? "B" : "R") + ")");
            printTree(node.left, indent, false);
            printTree(node.right, indent, true);
        }
    }
}
