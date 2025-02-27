package org.iti.app;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

    ArrayList<Integer> stackList;

    public MyStack() {
        stackList = new ArrayList<>();
    }


    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public void push(int i) {
        stackList.add(i);
    }

    public void push(List<Integer> items) {
        stackList.addAll(items);
    }

    public int getSize() {
        return stackList.size();
    }

    public int getPeek() {
        if (!isEmpty())
            return stackList.get(getSize() - 1);
        throw new IllegalStateException("Stack is Empty!");
    }

    public List<Integer> getCurrentStack() {
        if (!isEmpty())
            return stackList;
        throw new IllegalStateException("Stack is Empty!");
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is Empty!");
        int poppedItem = getPeek();
        stackList.remove(getSize() - 1);

        return poppedItem;
    }
}
