package org.woobolt.algorithms.arifmetics.BT_based;

public class App {
    public static void main(String[] args) {
        ArithmeticOnBinaryTree arb = new ArithmeticOnBinaryTree();

        // Создаем два бинарных дерева
        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(7);

        TreeNode t2 = new TreeNode(3);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(4);

        // Выполняем сложение деревьев
        TreeNode result = arb.addTrees(t1, t2);

        // Выводим результат
        printTree(result);
    }

    // Вспомогательная функция для печати бинарного дерева (обход в глубину)
    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}

