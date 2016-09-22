package datastructures;

import java.util.NoSuchElementException;
/**
 * Problem: 6
 * Page: 55
 * Date: 2015-08-25 
 * 
 * Rebuild a binary tree from the result of preorder and inorder traversal. The
 * tree node representation is implemented in the class <tt>BinaryTreeNode</tt>.
 * 
 * @author Xin Sun
 */
public class RebuildBinaryTree {

    private int[] preorder; // root -> left -> right
    private int[] inorder;  // left -> root -> right
    private int len;
    private int rootPreorder; // (sub)root index in preorder array
    private BinaryTreeNode root; // root node

    /**
     * The constructor of RebuildBinaryTree class. Two non-null arrays of
     * integers should be provided to rebuild the binary tree structure. Note
     * that the binary tree will not be automatically rebuild by the
     * constructor. You must invoke the <tt>rebuild()</tt> method on a
     * RebuildBinaryTree object.
     *
     * @param int[] preorder
     * @param int[] inorder
     */
    public RebuildBinaryTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        len = preorder.length;
        rootPreorder = 0; // start from the first element in preorder
        root = new BinaryTreeNode(preorder[0]);
    }

    /**
     * The method used to rebuild the binary tree structure.
     */
    public void rebuild() {
        int rootInorder = 0;
        // find the root index (rootInorder) in inorder array
        while (inorder[rootInorder] != root.value && rootInorder <= len - 2)
            rootInorder++;
        if (rootInorder == len - 1 && inorder[rootInorder] != root.value)
            throw new NoSuchElementException("Wrong input");

        root.left = rebuild(0, rootInorder-1);
        root.right = rebuild(rootInorder+1, len-1);
    }

    // Check code from here to end <-- Done
    private BinaryTreeNode rebuild(int startInorder, int endInorder) {
        if (startInorder > endInorder) return null; // do not forget base case

        rootPreorder++;
        assert rootPreorder < len;
        BinaryTreeNode subRoot = new BinaryTreeNode(preorder[rootPreorder]);

        int rootInorder = 0;
        while (inorder[rootInorder] != subRoot.value && rootInorder <= len - 2)
            rootInorder++;
        subRoot.left = rebuild(startInorder, rootInorder-1);
        subRoot.right = rebuild(rootInorder+1, endInorder);

        return subRoot;
    }
    
    /**
     * Print out the binary tree. This method invokes the
     * <tt>printTree(BinaryTreeNode node)</tt> in the class
     * <tt>BinaryTreeNode</tt>.
     */
    public void printTree() {
        BinaryTreeNode.printTree(root);
    }
    
    /**
     * Return the root of the binary tree.
     */
    public BinaryTreeNode getRoot() {
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] inorder = { 4, 7, 2, 1, 5, 3, 8, 6 };

        RebuildBinaryTree bt = new RebuildBinaryTree(preorder, inorder);
        bt.rebuild();
        bt.printTree();
    }
}
