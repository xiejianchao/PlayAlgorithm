package com.github.algorithm.util;

public class Log {

    public static void print(String msg) {
        System.out.print(msg);
    }

    public static void println(String msg) {
        System.out.println(msg);
    }

    public static void println(int msg) {
        System.out.println(msg);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
    }

    public static void print(Object obj) {
        System.out.print(obj);
    }

}
