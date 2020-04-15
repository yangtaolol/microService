package com.yangtao.linkedList;

public class Element<T> {

    private Element<T> nextEl;

    private T value;


    public Element(T value) {
        this.value = value;
    }

    public Element(T value, Element<T> nextEl) {
        this.value = value;
        this.nextEl = nextEl;
    }

    public void add(int index, T value, int currentIndex) {
        int deviation = index - currentIndex;
        if (deviation == 0) {
            nextEl = nextEl == null ? new Element<>(value) : new Element<>(value, nextEl);
        } else if (nextEl == null) {
            throw new IndexOutOfBoundsException();
        }else {
            nextEl.add(index, value, ++currentIndex);
        }
    }

    public Element<T> get(int index,int currentIndex) {
        if (currentIndex == index) {
            return this;
        } else if (nextEl == null) {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }else {
            return nextEl.get(index, ++currentIndex);
        }
    }

    public Element<T> next(){
        return nextEl;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T Value) {
        this.value = value;
    }

    public void setNextEl(Element<T> nextEl) {
        this.nextEl = nextEl;
    }
}
