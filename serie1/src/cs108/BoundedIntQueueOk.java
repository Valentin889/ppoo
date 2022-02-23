package cs108;

import java.util.ArrayList;

public class BoundedIntQueueOk implements BoundedIntQueue {

    private final ArrayList<Integer> contents;
    private int capacity;

    public BoundedIntQueueOk(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("illegal capacity: " + capacity + " (must be >= 0)");
        } else {
            this.contents = new ArrayList<Integer>();
            this.capacity = capacity;
        }
    }

    public int capacity() {
        return this.capacity;
    }

    public int size() {
        return this.contents.size();
    }

    public boolean isEmpty() {
        return this.contents.size() == 0;
    }

    public boolean isFull() {
        return this.contents.size() == this.capacity();
    }

    public void addLast(int newElement) {
        if (this.isFull()) {
            throw new IllegalStateException("full queue");
        }

        contents.add(newElement);

    }

    public int removeFirst() {
        if (this.isEmpty()) {
            throw new IllegalStateException("empty queue");
        }
        return contents.remove(0);
    }
}
