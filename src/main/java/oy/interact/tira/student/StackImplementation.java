package oy.interact.tira.student;

import oy.interact.tira.util.StackInterface;

public class StackImplementation<E> implements StackInterface<E> {

    private Object [] itemArray;
    //-1 means empty array
    // 0 means that there is 1 item
    // 9 means that there are 10 items
    // last index points to the index where the last stored element is
    private int lastIndex = -1;
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
        if (lastIndex > capacity()) {
            reallocate();
        }
        lastIndex += 1;
        itemArray[lastIndex] = element;
    }

    @Override
    public E pop() throws IllegalStateException {
        System.out.println();
        if (lastIndex >= 0) {
            Object temp = itemArray[lastIndex];
            itemArray[lastIndex] = null;
            lastIndex -= 1;
            return (E) temp;
        }
        throw new IllegalStateException("Tyhjä array");
    }

    @Override
    public E peek() throws IllegalStateException {
        if (lastIndex >= 0) {
            return (E) itemArray[lastIndex];
        }
        throw new IllegalStateException("Tyhjä array");
    }

    @Override
    public int size() {
        return lastIndex + 1;
    }

    @Override
    public boolean isEmpty() {
        return lastIndex == -1;
    }

    @Override
    public void clear() {
        Object [] tempArray= new Object[capacity()];
        itemArray = tempArray;

    }
    private void reallocate() {
        Object [] tempArray = new Object[capacity() * 2];
        for (int i = 0; i <= itemArray.length; i++) {
            tempArray[i] = itemArray[i];
            if (itemArray[i] != null) {
                break;
            }
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
                if (i < lastIndex) {
                    sb.append(", ");
                }
                }
            }
        sb.append("]");
        return sb.toString();
        }

    private void debug() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        System.out.println("Currently in method: " + stackTrace[2].getMethodName());
        System.out.println("Current Internal state:");
        System.out.println(toString());
        System.out.println("last index: " + lastIndex);
        System.out.println("capacity: " + capacity());
        System.out.println("size: " + size());
        System.out.println("\n");
    }
    }
