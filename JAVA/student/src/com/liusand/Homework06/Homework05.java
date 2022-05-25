package com.liusand.Homework06;

public class Homework05 {
    /*
        随机生成10个整数(1-100的范围)保存到数组，
        并倒序打印以及求平均值、求最大值和最大值下标、并查找里面是否有8
     */
    public static void main(String[] args) {
        int arr[] = new int[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * 100);
        }
        int sum = 0,max = arr[0],maxIndex = 0;
        boolean occur = false;
        for(int i = arr.length - 1; i >= 0; i--){
            System.out.print(arr[i] + " ");
            sum += arr[i];
            if(arr[i] > max){
                max = arr[i];
                maxIndex = arr.length - i - 1;
            }
            if(arr[i] == 8){
                occur = true;
            }
        }
        System.out.println("\n平均值:" + (sum / 10) + "最大值:" + max + "最大值下标:" + maxIndex + "是否有8:" + occur);

    }
}
