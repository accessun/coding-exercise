package io.github.accessun.datastructure;

/**
 * This class is an implementation of simple unidirectional linked list.
 * This implementation support several commonly used methods on linked list.
 *
 * @author Xin Sun
 */
public class SimpleLinkedList {

    /*
     * Unidirectional linked list is a simple data structure that is commonly
     * used to store data in a sequential fashion. One can add elements to a
     * linked list. The add element is appended to the tail of the list. The
     * remove() method removes the element at the tail. The following schematic
     * is a simple visualization of a typical unidirectional linked list. This
     * list has 5 elements. This first element, which is 3, is at the root
     * position. The last element, which is 9, is at the tail. Internally,
     * every element is implemented by a structure called Node, which stores
     * both the element's value and a reference to the next element. The last
     * element's reference to the next element is null since there is no
     * element after it.
     * 
     *   root(head)              tail
     *    |                       |
     *    |                       |
     *    3 --> 5 --> 7 --> 1 --> 9 --> null 
     */

    private Node root; // stores the reference to the root node
    private int size;

    /**
     * This inner class encapsulates data, which is simply an integer value,
     * and a reference to the next Node.
     */
    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    /**
     * Initializes an empty SimpleLinkedList.
     */
    public SimpleLinkedList() {
        root = null;
    }

    /**
     * Initializes an SimpleLinkedList from a given integer array. If a null
     * array is passed to the constructor, NullPointerException will be thrown.
     *
     * @throws NullPointerException
     */
    public SimpleLinkedList(int[] arr) throws NullPointerException {
        if (arr == null)
            throw new NullPointerException("The array passed to SimpleLinkedList(int[] arr) should not be null!");

        root = new Node(arr[0]);
        Node p = root;
        for (int i = 1; i < arr.length; i++) {
            p.next = new Node(arr[i]);
            p = p.next;
        }
    }

    /**
     * Adds a new element to the linked list.
     */
    public void add(int value) {
        if (root == null) {
            root = new Node(value);
        }
        else {
            Node p = root;
            while (p.next != null)
                p = p.next;
            p.next = new Node(value);
        }
        size++;
    }

    /**
     * Remove the last element from the linked list. If the list is empty,
     * UnsupportedOperationException will be thrown.
     *
     * @throws UnsupportedOperationException
     */
    public void remove() throws UnsupportedOperationException {
        if (root == null)
            throw new UnsupportedOperationException("Cannot remove from an empty list!");

        if (root.next == null)
            root = null;
        else {
            Node p1 = root;
            Node p2 = p1.next;
            while (p2.next != null) {
                p1 = p2;
                p2 = p2.next;
            }
            p1.next = null;
        }
        size--;
    }

    /**
     * Reverses the order of the linked list. Note that this is different from
     * printing the list in reverse order, since the internal struture of the 
     * list is changed by this method. The original tail is the root and the
     * original root is the tail after applying the method.
     */
    public void reverse() {
        if (root == null || root.next == null)
            return;

        Node p1 = root;
        Node p2 = p1.next;
        Node p3 = p2.next;
        p1.next = null;

        while (p3 != null) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        p2.next = p1;
        root = p2;
    }

    /**
     * Returns the size of the linked list (number of elements in the list).
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if the linked list is empty; otherwise, false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the index of the first occurrence of a specified value. If the
     * specified value is not in the linked list, the method returns -1. Note
     * that the index starts from 0.
     */
    public int find(int value) {
        int i = 0;
        for (Node p = root; p != null; p = p.next) {
            if (p.value == value)
                return i;
            i++;
        }
        return -1;
    }

    /**
     * Prints out the linked list. If the linked list is empty, this method
     * prints an empty line.
     */
    public void print() {
        print(root);
        System.out.println();
    }

    private void print(Node p) {
        if (p == null)
            return;
        System.out.print(p + " ");
        print(p.next);
    }

    /**
     * Prints out the linked list in reverse order. If the linked list is
     * empty, this method prints an empty line.
     */
    public void reversePrint() {
        reversePrint(root);
        System.out.println();
    }

    private void reversePrint(Node p) {
        if (p == null)
            return;
        reversePrint(p.next);
        System.out.print(p + " ");
    }

    /**
     * Returns the String representation of the linked list.
     */
    @Override
    public String toString() {
        if (root == null)
            return "[]";

        StringBuilder sb = new StringBuilder("[" + root.value);
        Node p = root.next;
        while (p != null) {
            sb.append(", ").append(p.value + "");
            p = p.next;
        }
        sb.append("]");

        return sb.toString();
    }

    // unit test
    public static void main(String[] args) {
        SimpleLinkedList list = new SimpleLinkedList();
        for (int i = 0; i < 10; i++)
            list.add(i);

        // test print() and reversePrint()
        System.out.println("----- test print() and reversePrint() -----");
        list.print();
        list.reversePrint();
        System.out.println("Size: " + list.size());

        // test remove()
        System.out.println("----- test remove() -----");
        list.remove();
        list.print();
        System.out.println("Size: " + list.size());

        // test reverse()
        System.out.println("----- test reverse() -----");
        list.reverse();
        list.print();
        
        // test find(int value)
        System.out.println("----- test find(int value) -----");
        list.print();
        System.out.println("Position of 8 is " + list.find(8));
        System.out.println("Position of 5 is " + list.find(5));
        System.out.println("Position of 0 is " + list.find(0));
        System.out.println("Position of 9 is " + list.find(9));

        // test toString()
        System.out.println("----- test toString() -----");
        System.out.println(list);
        list = new SimpleLinkedList(); // prints "[]"
        System.out.println(list);
        list = new SimpleLinkedList(new int[] {1});
        System.out.println(list);
    }
}
