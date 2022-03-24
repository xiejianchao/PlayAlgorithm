package com.github.algorithm.dp;

public class CuttingRope2 {

    public static void main(String[] args) {
        int n = cuttingRope(100);
        System.out.println("正确答案:" + n);
    }

    public static int cuttingRope(int n) {
        if(n < 4){
            return n - 1;
        }
        long res = 1;
        while(n > 4){
            res  = res * 3 % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }

}
