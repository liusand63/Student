package com.liusand.homework;

public class QuickSort {
    public static void quickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        int tmp = arr[left];
        int i = left + 1;
        int j = right;
        while(i < j){
            while(i < j && arr[i] <= tmp) i++;
            while(i < j && arr[j] >= tmp) j--;
            if(i < j){
                exchange(arr, i, j);
                i++;
                j--;
            }
        }
        if(i == j && arr[j] > tmp) j--;
        exchange(arr, left ,j);
        quickSort(arr, left, j - 1);
        quickSort(arr, j + 1, right);
    }
    private  static void exchange(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {1,23,32,12,41,26,15,17,8,3};
        quickSort(arr, 0, arr.length - 1);
        print(arr);
    }
}
