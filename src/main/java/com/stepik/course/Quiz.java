package com.stepik.course;

public class Quiz {
    /*
     * Для тех кому как и мне непонятно  как решать, дам небольшую подсказку,
     * вам нужно с переменной year проделать все операции которые указаны в задаче
     * " кратен 4, но при этом не кратен 100, либо кратен 400" но при этом нельзя применять
     * операторы &, &&, |, ||, вам нужно отнять  выражение "кратен 100" от выражения
     *  "кратен 4" и к ним прибавить выражение "кратен 400"
     * */
    public static void main(String[] args) {
        int[] a = testLeapYear(10);

    }

    public static int[] testLeapYear(int a) {
        int[] arr = new int[a];
        for (int i = 0; i < arr.length; i++) {
//            arr[i] = new Random();
        }
        return arr;
    }

    public static int leapYearCount(int year) {
        if ((year % 4 == 0) && ((year % 100 != 0) && (year % 400 == 0)))
            year /= 4;
        return year / 4;
    }
}