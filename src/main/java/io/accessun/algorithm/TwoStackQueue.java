package io.accessun.algorithm;

import java.util.Stack;

/**
 * Problem: 7
 * Page: 58
 * Date:
 *
 * Implementation of Queue by two Stacks. 
 *
 * @author Xin Sun
 */
public class TwoStackQueue<E> {
    private Stack<E> inStack;
    private Stack<E> outStack;
    private int size;

    public TwoStackQueue() {
        inStack = new Stack<E>();
        outStack = new Stack<E>();
        size = 0;
    }

    public int getSize() { return size; }

    // put everything from outStack to inStack
    // get prepared for enqueue operation
    private void toInStack() {
        if (outStack.empty())
            return;
        while (!outStack.empty()) // for (E i : outStack)
            inStack.push(outStack.pop());
    }

    // put everything from inStack to outStack
    // get prepared for dequeue operation
    private void toOutStack() {
        if (inStack.empty())
            return;
        while (!inStack.empty()) // for (E i : inStack) <-- this BUG sucks!
            outStack.push(inStack.pop());
    }

    public void enqueue(E item) {
        toInStack();
        assert outStack.empty();

        inStack.push(item);
        size++;
    }

    public E dequeue() {
        toOutStack();
        assert inStack.empty();

        if (outStack.empty())
            throw new UnsupportedOperationException("No elements in the queue!");

        E item = outStack.pop();
        size--;
        return item;
    }

    public boolean isEmpty() { return size == 0; }

    // /**
    //    used for debugging
    //  */
    // public void printInStack() {
    //     if (inStack.empty()) return;
    //     for (E i : inStack)
    //         System.out.print(i + " ");
    //     System.out.println();
    // }

    // /**
    //    used for debugging
    //  */
    // public void printOutStack() {
    //     if (outStack.empty()) return;
    //     for (E i : outStack)
    //         System.out.print(i + " ");
    //     System.out.println();
    // }

    // unit test
    public static void main(String[] args) {
        TwoStackQueue<Integer> tsq = new TwoStackQueue<Integer>();
        
        for (int i = 0; i < 10; i++) {
            tsq.enqueue(i);
        }

        // tsq.printInStack();
        // tsq.printOutStack();

        System.out.println(tsq.dequeue());
        // tsq.printInStack();
        // tsq.printOutStack();
        System.out.println(tsq.dequeue());
        System.out.println(tsq.dequeue());

        // expected output: 0 1 2
        System.out.println("There are still " + tsq.getSize() + " elements in the queue.");
    }
}
