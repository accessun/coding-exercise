package exercises;

import datastructures.BinaryTreeNode;
import datastructures.RebuildBinaryTree;

/**
 * This class provides a static method to get the maximum depth of a binary tree.
 *
 * @author Xin Sun
 */
public class BinaryTreeMaxDepth {
    /**
     * The method <tt>BinaryTreeMaxDepth(BinaryTreeNode node)</tt> returns the
     * maximum depth of a subtree rooted at <tt>node</tt> which is a
     * BinaryTreeNode object. If the BinaryTreeNode passed to this method is
     * null, the return value is 0. To get the max depth of a whole binary
     * tree, simply pass the root node to this method.
     */
    public static int maxDepth(BinaryTreeNode node) {
        return node == null ? 0 : 1 + max(maxDepth(node.left), maxDepth(node.right));
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    // unit test
    public static void main(String[] args) {
        int[] preorder = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] inorder = { 4, 7, 2, 1, 5, 3, 8, 6 };
        
        RebuildBinaryTree tree = new RebuildBinaryTree(preorder, inorder);
        tree.rebuild();
        System.out.println("Max depth of tree: " +  maxDepth(tree.getRoot())); // expected output: 4
    }
}
