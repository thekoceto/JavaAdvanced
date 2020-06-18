package com.company.P06_GenericCountMethodDouble;

public class Box<E extends Comparable<E>> implements Comparable<E> {
    private E element;

    public Box(E element) {
        this.element = element;
    }

    @Override
    public int compareTo(E outer){
        return element.compareTo(outer);
    }

    @Override
    public String toString() {
        return this.element.getClass().getName() + ": " + this.element;
    }
}