package com.liusand;

public class NumberOfLine {
    public static void main(String[] args) {
        int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        int arr[] = Solution.numberOfLines(widths,s);
        System.out.println(arr[0] + " " + arr[1]);
    }


}
class Solution {
    public static int[] numberOfLines(int[] widths, String s) {
        int width,sum = 0;
        int arr[] = new int[2];
        arr[0] = 1;
        for(int i = 0; i < s.length(); i++){
            width = widths[s.charAt(i) - 97];
            if((sum + width) > 100) {
                arr[0]++;
                sum = width;
            }else{
                sum += width;
            }
        }
        arr[1] = sum;
        return arr;
    }
}