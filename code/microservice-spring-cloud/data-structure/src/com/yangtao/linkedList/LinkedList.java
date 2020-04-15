package com.yangtao.linkedList;

public class LinkedList<T> {

    private Element<T> first;

    private int size = 0;

    public LinkedList<T> add(T value) {
        if (first == null) {
            first = new Element<>(value);
        }else {
            first.add(size - 1, value, 0);
        }
        size++;
        return this;
    }

    public LinkedList<T> add(int index, T value) {
        if (index < 0) {
            throw new IllegalArgumentException(String.valueOf(index));
        }
        if (index == 0) {
            first = first == null ? new Element<>(value) : new Element<>(value, first);
        }else {
            first.add(index, value, 0);
        }
        size++;
        return this;
    }

    public T get(int index){
        if (index < 0) {
            throw new IllegalArgumentException(String.valueOf(index));
        }
        if (first == null) {
            throw new IndexOutOfBoundsException("list is empty");
        }
        return first.get(index, 0).getValue();
    }
    public int size(){
        return size;
    }

    public Iterator<T> iterator(){
        return new Iterator<>(first);
    }

    public void clear() {
        while (first != null) {
            Element<T> next = first.next();
            first.setNextEl(null);
            first.setValue(null);
            first = next;
        }
        size = 0;
    }

    public T remove(){
        if (first == null) {
            return null;
        }
        Element<T> newEnd = first.get(size - 2, 0);
        Element<T> end = newEnd.next();
        T removeVal = end.getValue();
        end.setValue(null);
        newEnd.setNextEl(null);
        size--;
        return removeVal;
    }

    public T remove(int index) {
        if (first == null) {
            throw new IndexOutOfBoundsException("empty list");
        }
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        Element<T> el;
        Element<T> removeEl;
        if (index > 0) {
            el = first.get(index-1, 0);
            removeEl = el.next();
            el.setNextEl(removeEl.next());
        }else {
            removeEl = first;
            first = removeEl.next();
        }
        T removeVal = removeEl.getValue();
        removeEl.setValue(null);
        removeEl.setNextEl(null);
        size--;
        return removeVal;
    }

    public boolean remove(T value) {
        boolean flag = false;
        /*while (first != null) {
            Element<T> next = first.next();
            if(value==null)
        }*/
        return flag;
    }
}
