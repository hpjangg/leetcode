package medium;

// 1315. Sum of Nodes with Even-Valued Grandparent

import java.util.Optional;

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
        System.out.println(
                new No1315Implement().sumEvenGrandparent(getTestcase01())
        );
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

class No1315Implement {

    public int sumEvenGrandparent(TreeNode root) {
        return recursive(root);
    }

    private int recursive(TreeNode node) {
        Optional<TreeNode> myNode = Optional.ofNullable(node);

        if (!myNode.isPresent()) return 0;

        int result = process(myNode.get());

        result += myNode.map(s -> s.left)
                .map(this::recursive)
                .orElse(0);

        result += myNode.map(s -> s.right)
                .map(this::recursive)
                .orElse(0);

        return result;
    }

    private int process(TreeNode node) {
        int sum = 0;

        Optional<TreeNode> myNode = Optional.of(node);

        if (isEvenValue(myNode.get().val)) {

            sum += myNode.map(s -> s.left)
                    .map(s -> s.left)
                    .map(s -> s.val)
                    .orElse(0);

            sum += myNode.map(s -> s.left)
                    .map(s -> s.right)
                    .map(s -> s.val)
                    .orElse(0);

            sum += myNode.map(s -> s.right)
                    .map(s -> s.left)
                    .map(s -> s.val)
                    .orElse(0);

            sum += myNode.map(s -> s.right)
                    .map(s -> s.right)
                    .map(s -> s.val)
                    .orElse(0);

        }

        return sum;
    }

    private boolean isEvenValue(int value) {
        return value % 2 == 0;
    }

}
