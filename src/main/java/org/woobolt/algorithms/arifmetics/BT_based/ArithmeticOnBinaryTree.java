package org.woobolt.algorithms.arifmetics.BT_based;

public class ArithmeticOnBinaryTree {

    public TreeNode addTrees(TreeNode t1, TreeNode t2) {
        return addTreesHelper(t1, t2, 0);
    }

    private TreeNode addTreesHelper(TreeNode t1, TreeNode t2, int carry) {
        if (t1 == null && t2 == null) {
            return carry == 0 ? null : new TreeNode(carry);
        }

        int val1 = (t1 != null) ? t1.val : 0;
        int val2 = (t2 != null) ? t2.val : 0;

        int sum = val1 + val2 + carry;
        carry = sum / 10;
        TreeNode resultNode = new TreeNode(sum % 10);

        TreeNode left = (t1 != null) ? t1.left : null;
        TreeNode right = (t2 != null) ? t2.left : null;
        resultNode.left = addTreesHelper(left, right, carry);

        left = (t1 != null) ? t1.right : null;
        right = (t2 != null) ? t2.right : null;
        resultNode.right = addTreesHelper(left, right, carry);

        return resultNode;
    }
}