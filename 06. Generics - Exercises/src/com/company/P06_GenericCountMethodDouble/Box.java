package com.company.P06_GenericCountMethodDouble;

import java.util.List;

public class Box<T extends Comparable<T>>  implements Comparable<T>{
    private T value;

    public Box(T value){
        this.value = value;
    }


    @Override
    public int compareTo(T other) {
        return this.value.compareTo(other);
    }

    public T getValue(){
        return value;
    }
    public static <T extends Comparable<T>> int countGreaterValues(List<T> list, T value) {
        int c = 0;
        for (T t : list) {
            if (t.compareTo(value) > 0) {
                c++;
            }
        }
        return c;
    }
}