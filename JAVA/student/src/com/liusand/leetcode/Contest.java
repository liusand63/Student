package com.liusand.leetcode;

import java.util.ArrayList;

public class Contest {
    public static void main(String[] args) {
        Solution123 s = new Solution123();
        System.out.println(s.minimizeResult("1+3"));

    }
}
class Solution123 {
    public String minimizeResult(String expression) {
        ArrayList<Character> a = new ArrayList<Character>();
        for(int i = 0; i < expression.length(); i++){
            a.add(expression.charAt(i));
        }
        int plus = a.indexOf('+');
        int left = 0, right = a.size() - 1;
        int min = 0, low = left, high = right;
        while(left < right - 2){
            int l = 0, mid = 0, r = 0, tmp = 0;
            for(int i = 0; i < a.size(); i++){
                if(i < left){
                    l = l * 10 + (a.get(i) - '0');
                }else if(i > right){
                    r = r * 10 + (a.get(i) - '0');
                }else{
                    if(i == plus){
                        mid = tmp;
                        tmp = 0;
                    }else{
                        tmp = tmp * 10 + (a.get(i) - '0');
                    }
                    if(i == right){
                        mid += tmp;
                    }
                }
            }
            int t = (l == 0 ? 1 : l) * (r == 0 ? 1 : r) * mid;
            if(min == 0 || t < min){
                min = t;
                low = left;
                high = right;
            }
            if(right > plus + 1){
                right--;
            }else if(left < plus - 1){
                left++;
                right = a.size() - 1;
            }
        }
        a.add(low,'(');
        a.add(high + 2,')');
        String re = "";
        for(int i = 0; i < a.size(); i++){
            re = re + a.get(i);
        }
        return re;
    }
}