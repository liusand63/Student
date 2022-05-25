package com.liusand.Homework06;

public class Homework07 {
    //冒泡排序
    public static void main(String[] args) {
        int arr[] = {56,23,48,45,12,98,456,55};
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
        int temp;
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int num : arr){
            System.out.print(num + " ");
        }

    }
}
