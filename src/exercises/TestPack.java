package exercises;

import datastructures.BinaryTreeNode;
import datastructures.RebuildBinaryTree;

public class TestPack {
    public static void main(String[] args) {
        int[] preorder = { 1, 2, 4, 5, 3, 6 };
        int[] inorder = { 4, 2, 5, 1, 3, 6 };
        RebuildBinaryTree bt = new RebuildBinaryTree(preorder, inorder);
        bt.rebuild();
        bt.printTree();
    }
}
