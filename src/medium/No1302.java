package medium;

import java.util.LinkedList;
import java.util.Optional;

/**
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 * Example 2:
 *
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 19
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 100
 */

public class No1302 {

    public static void main(String[] args) {
        System.out.println(
                new No1302Implement().deepestLeavesSum(getTestCase01())
        );
    }

    private static TreeNode getTestCase01() {
        TreeNode treeNode_3_0 = new TreeNode(7);
        TreeNode treeNode_3_7 = new TreeNode(8);

        TreeNode treeNode_2_0 = new TreeNode(4);
        treeNode_2_0.left = treeNode_3_0;
        TreeNode treeNode_2_1 = new TreeNode(5);
        TreeNode treeNode_2_3 = new TreeNode(6);
        treeNode_2_3.right = treeNode_3_7;

        TreeNode treeNode_1_0 = new TreeNode(2);
        treeNode_1_0.left = treeNode_2_0;
        treeNode_1_0.right = treeNode_2_1;
        TreeNode treeNode_1_1 = new TreeNode(3);
        treeNode_1_1.right = treeNode_2_3;

        TreeNode root = new TreeNode(1);
        root.left = treeNode_1_0;
        root.right = treeNode_1_1;

        return root;
    }

}

class No1302Implement {

    public int deepestLeavesSum(TreeNode root) {
        int result = 0;

        LinkedList<TreeNode> linkedList = initTreeForRoot(root);

        while (!linkedList.isEmpty()) {
            result = 0;
            for (int i = linkedList.size() - 1; i >= 0; i--) {
                TreeNode node = linkedList.poll();
                result += Optional.ofNullable(node).map(s -> s.val).orElse(0);
                addForLinkedList(linkedList, node);
            }
        }

        return result;
    }

    private LinkedList<TreeNode> initTreeForRoot(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        return linkedList;
    }

    private void addForLinkedList(LinkedList<TreeNode> linkedList, TreeNode node) {
        Optional<TreeNode> optionalNode = Optional.ofNullable(node);

        optionalNode.map(s -> s.left)
                .map(linkedList::add);

        optionalNode.map(s -> s.right)
                .map(linkedList::add);
    }

}
