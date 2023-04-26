package model;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Queue<T> {
    private ArrayList<T> queue;

    public Queue() {
        queue = new ArrayList<>();
    }

    public void enqueue(T data) {
        queue.add(data);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return queue.remove(0);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return queue.get(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void print() {
        for (T data : queue) {
            System.out.println(data);
        }
        System.out.println();
    }
}