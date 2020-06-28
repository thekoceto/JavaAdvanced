package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        char[] oldOne = new char[]{'a', 'b', 'c', 'd'};
        char[] newOne = new char[10];
        Arrays.fill(newOne, ' ');
        System.arraycopy(oldOne, 0, newOne, 0, oldOne.length);
        System.out.println();
    }
}
