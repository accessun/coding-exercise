package datastructures;

/* *********************************************************************
 * 
 * Compilation:			javac MyDeque.java
 * Execution (Testing):	java MyDeque < test_file
 * Dependencies:		none
 * Test files:			test_MyDeque_1.txt
 * 						test_MyDeque_2.txt
 * 						test_MyDeque_3.txt
 * Examples:
 * $ java MyDeque < test_MyDeque_1.txt
 * $
 * $ java MyDeque < test_MyDeque_2.txt
 * $
 * $ java MyDeque < test_MyDeque_3.txt
 * $
 * 
 **********************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class is a linked-list implementation of the <tt>Deque</tt> data
 * structure. Elements can be added or removed from both the beginning
 * and the end of a <tt>Deque</tt>.
 * 
 * @author Xin Sun
 */
public class MyDeque<E> implements Iterable<E> {
    private Node first;
    private Node last;
    private int N;  // number of elements in the deque
    
    private class Node {
        private E item;
        private Node prev;
        private Node next;
    }
    
    public MyDeque() {
        first = null;
        last = null;
        N = 0;
    }
    
    /**
     * Is the deque empty?
     * @return If it is empty, the return value is true, otherwise, false.
     */
    public boolean isEmpty() {
        return first == null;
    }
    
    /**
     * Get the number of elements in the deque.
     * @return an integer of how many elements are in the deque.
     */
    public int size() {
        return N;
    }
    
    /**
     * Add an element from the head of the deque.
     * @param item of type E
     */
    public void addFirst(E item) {
        if (item == null) throw new NullPointerException();

        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;    

        if (size() == 1) {
            last = first;
            return;
        }
        oldfirst.prev = first;
    }
    
    /**
     * Add an element from the tail of the deque.
     * @param item of type E
     */
    public void addLast(E item) {
        if (item == null) throw new NullPointerException();

        if (isEmpty()) {
            addFirst(item);
            return;
        }
        Node oldlast = last;
        last = new Node();
        last.item = item;
        oldlast.next = last;
        last.prev = oldlast;
        N++;
    }
    
    /**
     * Remove an element from the head of the deque.
     * @return item of type E
     */
    public E removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");

        E item = first.item;
        first = first.next;
        if (first != null)
        	first.prev = null;
        else
        	last = null;

        N--;

        return item;
    }
    
    /**
     * Remove an element from the tail of the deque.
     * @return item of type E
     */
    public E removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");

        E item = last.item;
        last = last.prev;

        if (last != null)
        	last.next = null;
        else
        	first = null;

        N--;
        return item;
    }
    
    public Iterator<E> iterator() {
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator<E> {
        private Node current = first;
        private int i = N;
        
        public boolean hasNext() {
            return i > 0;
        }
        
        public E next() { // modified 
            if (!hasNext()) throw new NoSuchElementException();
            E item = current.item;
            current = current.next;
            i--;
            return item;
        }
        
        /**
         * This implementation does not support remove operation.
         */
        public void remove() { throw new UnsupportedOperationException(); }
    }
    
    /*
     * Unit test: The program reads from text file with a list of "first" and "last"
     * strings. If the read word is "first", this word is added to the head of the
     * deque. If it is "last", it is added to the tail. If a "-" is read, an element
     * is removed from the head, otherwise, an element is removed from the tail.
     */
    public static void main(String[] args) {
        MyDeque<String> s = new MyDeque<String>();
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNext()) {
            String item = sc.next();
            if (item.equals("first")) s.addFirst(item);
            else if (item.equals("last")) s.addLast(item);
            else if (item.equals("-")) System.out.print(s.removeFirst() + ":F ");
            else System.out.print(s.removeLast() + ":L ");
        }
        System.out.println("(" + s.size() + " left in the deque)");
        
        sc.close();
    }
}
