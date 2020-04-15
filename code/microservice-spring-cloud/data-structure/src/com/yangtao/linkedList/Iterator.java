package com.yangtao.linkedList;

import java.util.NoSuchElementException;

public class Iterator<T>{
    private Element<T> element;

    public Iterator(Element<T> element) {
        this.element = element;
    }

    public boolean hasNext(){
        return element!= null;
    }

    public T next(){
        if (element == null) {
            throw new NoSuchElementException();
        }
        T nextValue = element.getValue();
        element = element.next();
        return nextValue;
    }

}
