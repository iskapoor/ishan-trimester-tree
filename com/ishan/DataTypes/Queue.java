package com.ishan.DataTypes;

import java.util.ArrayList;

public class Queue<T> {
    private ArrayList<T> queue = new ArrayList<T>();
    
    public void enqueue(T e) {
        this.queue.add(e);
    }

    public void dequeue() {
        this.queue.remove(0);
    }

    public T peek() {
        return this.queue.get(0);
    }

    public int size() {
        return this.queue.size();
    }

    public String toString() {
        String output = "";
        for (T i : queue) {
            output += i + " ";
        }
        return output;
    }

    public String formattedString() {
        String output = "[";
        for (Object i : queue) {
            output += i + ", ";
        }
        output = output.substring(0, output.length()-2) + "]";
        return output;
    }
}
