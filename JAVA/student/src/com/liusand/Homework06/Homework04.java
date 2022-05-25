package com.liusand.Homework06;
import java.util.Scanner;

public class Homework04 {
    /*
        已知有个升序的数组，要求插入一个元素，该数组顺序依然是升序，比如：
        [10,12,45,90],添加23后,数组为[10,12,23,45,90]
     */

    public static void main(String[] args) {
        int arr[] = {10,12,45,90};
        int newArr[] = new int[arr.length + 1];
        int index = 0;
        Scanner in = new Scanner(System.in);
        int addNum = in.nextInt();
        for(int i = 0; i < arr.length; i++){
            if(i == index && addNum < arr[i]){
                newArr[index++] = addNum;
            }
            newArr[index++] = arr[i];
        }
        arr = newArr;
        System.out.println(arr);
    }


}
