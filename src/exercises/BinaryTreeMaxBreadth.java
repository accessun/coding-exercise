package exercises;

import datastructures.BinaryTreeNode;
import datastructures.RebuildBinaryTree;

/**
 * This class provides a way to get the maximum breadth of a binary tree. The
 * maximum breadth is defined as the maximum among the numbers of nodes in each
 * level of tree. This program code stipulates the root level as level 1 for
 * convenience. To use the method in this class, one first need to instantiate
 * an object of this class, then invoke the method needed to get the value.
 *
 * @author Xin Sun
 */
public class BinaryTreeMaxBreadth {
    private int level;
    private BinaryTreeNode root;
    private int[] count;

    /**
     * The constructor of the class BinaryTreeMaxBreadth. In order to get the
     * maximum breadth of a tree, one need to provide the root node to the
     * constructor. If one instead want to get the max breadth rooted from a
     * specific node, just pass that node to the constructor. Note that the
     * node should be of type <tt>BinaryTreeNode</tt>. The
     * <tt>BinaryTreeNode</tt> class is provided in the <tt>datastructures</tt>
     * package.
     */
    public BinaryTreeMaxBreadth(BinaryTreeNode root) {
        level = 0;
        this.root = root;
        int depth = BinaryTreeMaxDepth.maxDepth(root);
        count = new int[depth + 1];
    }

    /**
     * The method used to get the maximum breadth of a binary tree. If the tree
     * is an empty tree, the returned value will be 0.
     *
     * @return int
     */
    public int maxBreadth() {
        maxBreadth(root);
        return maxInArray(count);
    }

    private void maxBreadth(BinaryTreeNode node) {
        if (node == null)
            return;
        level++;
        count[level] = count[level] + 1;
        maxBreadth(node.left);
        maxBreadth(node.right);
        level--;
    }

    private int maxInArray(int[] arr) {
        int m = Integer.MIN_VALUE;
        for (int val : arr)
            if (val > m)
                m = val;
        return m;
    }

    // unit test
    public static void main(String[] args) {
        int[] preorder = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] inorder = { 4, 7, 2, 1, 5, 3, 8, 6 };
        RebuildBinaryTree rebuildTree = new RebuildBinaryTree(preorder, inorder);
        rebuildTree.rebuild();

        BinaryTreeMaxBreadth btBreadth = new BinaryTreeMaxBreadth(rebuildTree.getRoot());
        System.out.println("Max breath of tree: " + btBreadth.maxBreadth());
    }
}
