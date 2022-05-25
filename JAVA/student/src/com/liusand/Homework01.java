package com.liusand;
import java.util.Scanner;

//输出一个空心菱形
public class Homework01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        for(int i = 0, ii = 0; i < len * 2 - 1;){
            for(int j = len - 1 - ii; j > 0; j--){
                System.out.print(" ");
            }
            for(int j = 0; j < ii * 2 + 1; j++){
                if(j == 0 || j == ii * 2){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
            if(++i > len - 1){
                ii--;
            }else{
                ii++;
            }
        }
    }

}
