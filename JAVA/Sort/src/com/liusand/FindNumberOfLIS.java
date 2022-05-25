package com.liusand;

public class FindNumberOfLIS {

    public static int findNumberOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length], sum = new int[nums.length];
        int num = 1;
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            sum[dp[i] - 1]++;
        }
        for(int i = 0; i < sum.length; i++){
            if(sum[i] != 0){
                num *= sum[i];
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,3,5,4,7,2};
        findNumberOfLIS(nums);
    }
}

