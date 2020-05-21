package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayDeque<Integer> deque = Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toCollection(ArrayDeque::new));

        for(Iterator descItr = deque.descendingIterator();descItr.hasNext();)
            System.out.print(descItr.next() + " ");
    }
}
