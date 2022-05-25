package com.liusand;

public class Sort {
    public static int[] selectionSort(int[] arr){
        int smallest,smallestIndex = 0,temp;
        for(int i = 0; i < arr.length; i++){
            smallest = arr[i];
            smallestIndex = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[j] < smallest){
                    smallest = arr[j];
                    smallestIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {5,3,6,2,10};
        print(arr);
        print(selectionSort(arr));
    }
    public static void print(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }



}
