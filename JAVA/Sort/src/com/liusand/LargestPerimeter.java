package com.liusand;

public class LargestPerimeter {
    public static int largestPerimeter(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if((nums[i] < nums[j] + nums[k]) && (nums[j] < nums[i] + nums[k]) && (nums[k] < nums[i] + nums[j])){
                        max = Math.max(max, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,2};
        largestPerimeter(nums);

    }
}
