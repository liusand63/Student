package com.liusand;

public class KLengthApart {
    public static boolean kLengthApart(int[] nums, int k) {
        int i = 0, ans = k;
        while(i < nums.length){
            if(nums[i] == 1){
                if(ans >= k){
                    ans = 0;
                }else return false;
            }else{
                ans++;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1};
        boolean r = kLengthApart(nums, 2);
        System.out.println(r);
    }
}
