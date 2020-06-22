package com.company.P05_GenericCountMethodString;

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
}