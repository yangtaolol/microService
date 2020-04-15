package com.yangtao.stack;

import java.util.EmptyStackException;

public class Stack <T>{

    private static final int DEFAULT_CAPACITY = 16;

    private Object[] arr;

    private int place = -1;

    private int size;

    public Stack(){
        arr = new Object[DEFAULT_CAPACITY];
        this.size = DEFAULT_CAPACITY;
    }

    public Stack(int capacity) {
        if (capacity >=0) {
            size = capacity;
            arr = new Object[size];
        }else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    capacity);
        }
    }

    public boolean isEmpty(){
        return place == -1;
    }

    public int size(){
        return place + 1;
    }

    public T pop(){
        if (place == -1) {
            throw new EmptyStackException();
        }
        T temp = (T) arr[place];
        arr[place] = null;
        place--;
        return temp;
    }

    public void push(T element) {
        if (place == size - 1) {
            size += DEFAULT_CAPACITY;
            Object[] tempArr = new Object[size];
            for (int i = 0; i < arr.length; i++) {
                tempArr[i] = arr[i];
                arr[i] = null;
            }
            arr = tempArr;
        }
        place++;
        arr[place] = element;
    }

    public T top(){
        if (place == -1) {
            throw new EmptyStackException();
        }
        return (T) arr[place];
    }
}


