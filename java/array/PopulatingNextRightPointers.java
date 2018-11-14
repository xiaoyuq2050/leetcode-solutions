package array;

public class PopulatingNextRightPointers {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;
        TreeLinkNode leftmost = root;
        while (cur.left != null) {
            cur.left.next = cur.right;
            if (cur.next == null) {
                cur = leftmost.left;
                leftmost = cur;
            } else {
                cur.right.next = cur.next.left;
                cur = cur.next;
            }
        }
    }

}
