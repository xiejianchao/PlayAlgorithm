package com.github.algorithm.others;

public class HammingWeight {

    public static void main(String[] args) {
        int data = 00000000000000000000000000001011;
        int newData = data >>> 1;
        int i = hammingWeight(data);
        System.out.println("res:" + i);
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

}
