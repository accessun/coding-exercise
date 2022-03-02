package io.accessun.javafeature.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple cyclic list implementation
 *
 * @author Xin Sun
 *
 * @param <T>
 */
public class SimpleCyclicList<T> {
    private volatile int cursor = 0;
    private final List<T> list;
    private final int size;

    public SimpleCyclicList(List<T> list) {
        Objects.requireNonNull(list);
        if (list.isEmpty())
            throw new UnsupportedOperationException("Operation on null or empty list is not supported");

        this.list = new ArrayList<>(list);
        this.size = this.list.size();
    }

    /**
     * Returns the current element in the iteration and forwards the cursor.
     */
    public synchronized T next() {
        T value = list.get(cursor++);
        if (cursor == size)
            cursor = 0;
        return value;
    }

    /**
     * Forwards the internal cursor by one position.
     */
    public synchronized void advance() {
        cursor = (cursor >= size - 1) ? 0 : cursor + 1;
    }

    /**
     * Returns the current element without movement of the cursor.
     *
     * @return
     */
    public synchronized T get() {
        return list.get(cursor);
    }

}