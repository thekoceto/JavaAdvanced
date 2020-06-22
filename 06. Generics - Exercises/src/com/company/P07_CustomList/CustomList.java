package com.company.P07_CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<T>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public T remove(int index) {
        return this.list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int index, int index2) {
        T tmp = this.list.get(index);
        this.list.set(index, this.list.get(index2));
        this.list.set(index2, tmp);
    }

    public int countGreaterThat(T element) {
        int count = 0;
        for (T currentElement : this.list) {
            if (currentElement.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        T max = this.list.get(0);
        for (int i = 1; i < this.list.size(); i++) {
            T currentElement = this.list.get(i);
            if (currentElement.compareTo(max) > 0) {
                max = currentElement;
            }
        }
        return max;
    }

    public T getMin() {
        T min = this.list.get(0);
        for (int i = 1; i < this.list.size(); i++) {
            T currentElement = this.list.get(i);
            if (currentElement.compareTo(min) < 0) {
                min = currentElement;
            }
        }
        return min;
    }

    public List<T> getList() {
        return Collections.unmodifiableList(this.list);
    }
}