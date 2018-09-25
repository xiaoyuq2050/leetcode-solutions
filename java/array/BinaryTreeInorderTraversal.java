package array;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        recursion(root, res);
        return res;
    }

    private static void recursion(TreeNode node, List<Integer> res) {
        if (node.left != null) {
            recursion(node.left, res);
        }
        res.add(node.val);
        if (node.right != null) {
            recursion(node.right, res);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
