package medium;

/**
 * Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)
 *
 * If there are no nodes with an even-valued grandparent, return 0.
 *
 *
 * Example 1:
 *
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 18
 * Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is between 1 and 10^4.
 * The value of nodes is between 1 and 100.
 */

public class No1315 {

    public static void main(String[] args) {
        sumEvenGrandparent(getTestcase01());
    }

    public static int sumEvenGrandparent(TreeNode root) {
        return recursive(root);
    }

    private static int recursive(TreeNode node) {
        int result = process(node);

        if (node.right != null) {
            result += recursive(node.right);
        }

        if (node.left != null) {
            result += recursive(node.left);
        }

        return result;
    }

    private static int process(TreeNode node) {
        int sum = 0;
        if (node.val % 2 == 0) {
            if (node.left != null) {
                if (node.left.left != null) {
                    sum += node.left.left.val;
                }

                if (node.left.right != null) {
                    sum += node.left.right.val;
                }
            }

            if (node.right != null) {
                if (node.right.left != null) {
                    sum += node.right.left.val;
                }

                if (node.right.right != null) {
                    sum += node.right.right.val;
                }
            }
        }
        return sum;
    }

    private static TreeNode getTestcase01() {
        TreeNode treeNode_3_0 = new TreeNode(9);
        TreeNode treeNode_3_2 = new TreeNode(1);
        TreeNode treeNode_3_3 = new TreeNode(4);
        TreeNode treeNode_3_7 = new TreeNode(5);

        TreeNode treeNode_2_0 = new TreeNode(2);
        treeNode_2_0.left = treeNode_3_0;
        TreeNode treeNode_2_1 = new TreeNode(7);
        treeNode_2_1.left = treeNode_3_2;
        treeNode_2_1.right = treeNode_3_3;
        TreeNode treeNode_2_2 = new TreeNode(1);
        TreeNode treeNode_2_3 = new TreeNode(3);
        treeNode_2_3.right = treeNode_3_7;

        TreeNode treeNode_1_0 = new TreeNode(7);
        treeNode_1_0.left = treeNode_2_0;
        treeNode_1_0.right = treeNode_2_1;

        TreeNode treeNode_1_1 = new TreeNode(8);
        treeNode_1_1.left = treeNode_2_2;
        treeNode_1_1.right = treeNode_2_3;

        TreeNode root = new TreeNode(6);
        root.left = treeNode_1_0;
        root.right = treeNode_1_1;

        return root;
    }
}
