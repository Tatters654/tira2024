package oy.interact.tira.student;

import oy.interact.tira.util.StackInterface;

public class StackImplementation<E> implements StackInterface<E> {

    private Object [] itemArray;
    //-1 means empty array
    // 0 means that there is 1 item
    // 9 means that there are 10 items
    // last index points to the index where the last stored element is
    private int count = -1;
    private static final int DEFAULT_STACK_SIZE = 32;

    public StackImplementation() {
        itemArray = new Object[DEFAULT_STACK_SIZE];
    }
    public StackImplementation(int size) {
        itemArray = new Object[size];
    }

    @Override
    public int capacity() {
        return itemArray.length;
    }

    @Override
    public void push(E element) throws OutOfMemoryError, NullPointerException {
        debug();
        System.out.println("Pushing: " + element);
        //jos yritetty push on OoB, niin reallocate
        if (element == null) {
            System.out.println("Null pushed");
            throw new NullPointerException("Null was trying to be pushed");
        }
        if (count + 1 == capacity()) {
            reallocate();
        }
        count += 1;
        itemArray[count] = element;
        System.out.println(toString());
    }

    @Override
    public E pop() throws IllegalStateException {
        if (count >= 0) {
            System.out.println("popping element:" + count);
            Object temp = itemArray[count];
            itemArray[count] = null;
            count -= 1;
            return (E) temp;
        }
        throw new IllegalStateException("Tyhjä array");
    }

    @Override
    public E peek() throws IllegalStateException {
        if (count >= 0) {
            return (E) itemArray[count];
        }
        throw new IllegalStateException("Tyhjä array");
    }

    @Override
    public int size() {
        return count + 1;
    }

    @Override
    public boolean isEmpty() {
        return count == -1;
    }

    @Override
    public void clear() {
        Object [] tempArray = new Object[capacity()];
        itemArray = tempArray;
        count = -1;
    }

    private void reallocate() {
        System.out.println("allocating new memory");
        Object [] tempArray = new Object[capacity() * 2];
        for (int i = 0; i <= count; i++) {
            tempArray[i] = itemArray[i];
        }
        itemArray = tempArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < itemArray.length; i++) {
            if (itemArray[i] != null) {
                sb.append(itemArray[i]);
                if (i < count) {
                    sb.append(", ");
                }
                }
            }
        sb.append("]");
        return sb.toString();
        }

    private void debug() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        System.out.println("\n");
        System.out.println("Currently in method: " + stackTrace[2].getMethodName());
        System.out.println("Current Internal state:");
        System.out.println(toString());
        System.out.println("count: " + count);
        System.out.println("capacity: " + capacity());
        System.out.println("size: " + size());
        System.out.println("\n");
    }
    }
