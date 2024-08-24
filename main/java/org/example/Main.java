package org.example;

public class Main {
    public static void main(String[] args) {
       MyArrayList<Integer> arrayList = new MyArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        System.out.println(arrayList.contains(8));
    }
}