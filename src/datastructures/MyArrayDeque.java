package datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyArrayDeque<Item> implements Iterable<Item> {
    private Item[] a;
    private int NFIRST;
    private int NLAST;
    
    public MyArrayDeque() {
        a = (Item[]) new Object[2];
    }
    
    public boolean isEmpty() {
        return NFIRST - NLAST == 0;
    }
    
    public int size() {
        return NFIRST - NLAST;
    }
    
    public void addFirst(Item item) {
        a[a.length/2+NFIRST] = item;
        NFIRST++;
        if (abs(NFIRST) == a.length/2) resize(2*a.length);
    }
    
    public void addLast(Item item) {
        a[a.length/2+NLAST-1] = item;
        NLAST--;
        if (abs(NLAST) == a.length/2) resize(2*a.length);
    }
    
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = a[a.length/2+NFIRST-1];
        a[a.length/2+NFIRST-1] = null; // avoid loitering
        NFIRST--;
        if ((NFIRST >= NLAST) && NFIRST == a.length/8) resize(a.length/2);
        return item;
    }
    
    public Item removeLast() {
        Item item = a[a.length/2+NLAST];
        a[a.length/2+NLAST] = null; // avoid loitering
        NLAST++;
        if ((NFIRST <= abs(NLAST)) && abs(NLAST) == a.length/8) resize(a.length/2);
        return item;
    }
    
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        if (capacity > a.length) {
            int j = 0;
            for (int i = a.length/2; i < a.length*3/2; i++) {
                copy[i] = a[j];
                j++;
            }
            a = copy;
        }
        
        if (capacity < a.length) {
            int j = 0;
            for (int i = a.length/4; i < a.length/4+capacity; i++) {
                copy[j] = a[i];
                j++;
            }
            a = copy;
        }
    }
    
    private int abs(int val) {
        if (val >= 0) return val;
        else return -val;
    }
    
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }
    
    private class ArrayIterator implements Iterator<Item> {
        private int front = NFIRST;
        private int end = NLAST;
        
        public boolean hasNext() {
            return a.length / 2 + front > a.length / 2 - 1 - end;
        }
        
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            front--;
            return a[a.length/2+front];
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    public static void main(String[] args) {
        MyArrayDeque<String> s = new MyArrayDeque<String>();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String item = sc.next();
            if      (item.equals("first"))    s.addFirst(item);
            else if (item.equals("last"))    s.addLast(item);
            else if (item.equals("*"))    System.out.print(s.removeFirst() + ":F ");
            else /* (item.equals("/")) */ System.out.print(s.removeLast() + ":L ");
        }
        System.out.println("(" + s.size() + " left on the deque)");
        
        sc.close();
    }
}
