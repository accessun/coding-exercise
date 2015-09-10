import java.util.NoSuchElementException;
/**
 * Problem: 6
 * Page: 55
 * Date: 2015-08-25 
 * 
 * Rebuild a binary tree from the result of preorder and inorder traversal.
 * 
 * @author Xin Sun
 */
public class RebuildBinaryTree {

    private int[] preorder; // root -> left -> right
    private int[] inorder;  // left -> root -> right
    private int len;
    private int rootPreorder; // (sub)root index in preorder array
    private BinaryTreeNode root; // root node

    public RebuildBinaryTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        len = preorder.length;
        rootPreorder = 0; // start from the first element in preorder
        root = new BinaryTreeNode(preorder[0]);
    }

    private class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right; 

        public BinaryTreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

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

    // Check code from here to end
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

    private void printTree() {
        printTree(root);
    }

    private void printTree(BinaryTreeNode node) {
        if (node == null) return;

        if (node.left != null)
            System.out.print(node.left.value);
        else
            System.out.print("null");

        System.out.print(" <-- " + node.value + " --> ");

        if (node.right != null)
            System.out.println(node.right.value);
        else
            System.out.println("null");

        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String[] args) {
        int[] preorder = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] inorder = { 4, 7, 2, 1, 5, 3, 8, 6 };

        RebuildBinaryTree bt = new RebuildBinaryTree(preorder, inorder);
        bt.rebuild();
        bt.printTree();
    }
}

