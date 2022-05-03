package com.ishan.DataTypes;
import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> stack = new ArrayList<>();

    public void push(T e) {
        this.stack.add(e);
    } //add last

    public void pop() {
        this.stack.remove(this.stack.size()-1);
    } //remove last

    public T peek() {
        return this.stack.get(this.stack.size()-1);
    } //see last

    public int size() {
        return this.stack.size();
    } //see size

    public String toString() {
        String output = "";
        for (T i : stack) {
            output += i + " ";
        }
        return output;
    }

    public String formattedString() {
        String output = "[";
        for (Object i : stack) {
            output += i + ", ";
        }
        output = output.substring(0, output.length()-2) + "]";
        return output;
    }
}
