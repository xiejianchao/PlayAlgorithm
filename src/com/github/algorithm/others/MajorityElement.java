package com.github.algorithm.others;

import com.github.algorithm.util.Log;

public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        int[] arr = {2, 2, 3, 2, 5, 6, 2};
        int i = obj.majorityElement(arr);
        Log.print("res:" + i);
    }

    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

}
