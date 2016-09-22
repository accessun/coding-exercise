package datastructures;

/**
 * This class is an implementation of tree node of a typical binary tree data
 * structure. There are three instance fields in this class, all of which are
 * accessible within the package this class resides. The first field
 * <tt>value</tt> is an integer value stored in a tree node.The other two fields
 * <tt>left</tt> and <tt>right</tt> are two links that direct to left and right
 * child node of <tt>this</tt> node.
 *
 * @author Xin Sun
 */
public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    /**
     * The constructor of <tt>BinaryTreeNode</tt>. An integer value should be
     * passed to this constructor. The left and right links to the child nodes
     * are initialized to be null.
     *
     * @param int value
     */
    public BinaryTreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    /**
     * Print out the binary tree structure down a specified node (inclusively).
     * If the node is the root, the whole tree structure will be printed out.
     *
     * @param BinaryTreeNode node
     */
    public static void printTree(BinaryTreeNode node) {
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

    /**
     * The String representation of a single node.
     */
    @Override
    public String toString() {
        String s = value + "";
        
        if (left != null)
            s = "<-- " + s;
        else
            s = "    " + s;

        if (right != null)
            s = s + " -->";
        else
            s = s + "    ";

        return s;
    }

    public static void main(String[] args) {
        System.out.println("Testing BinaryTreeNode ...");
        
        System.out.println("For a single node:");
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        System.out.println(node1.toString());

        System.out.println("Node with left side link:");
        BinaryTreeNode node2 = new BinaryTreeNode(1);
        node2.left = new BinaryTreeNode(2);
        System.out.println(node2.toString());

        System.out.println("Node with right side link:");
        BinaryTreeNode node3 = new BinaryTreeNode(1);
        node3.right = new BinaryTreeNode(3);
        System.out.println(node3.toString());

        System.out.println("Node with both sides links:");
        BinaryTreeNode node4 = new BinaryTreeNode(1);
        node4.left = new BinaryTreeNode(2);
        node4.right = new BinaryTreeNode(3);
        System.out.println(node4.toString());
    }
}
