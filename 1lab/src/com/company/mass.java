package com.company;

import java.lang.reflect.Array;
import java.util.Scanner;
import   java.util.Arrays;

public class mass {
   private short[] arr;
   private int n;

   public mass(int n){
       this.n = n;
       arr = new short[n];
   }

   public void showl(){
       for(int i = 0; i < n; i++){
           System.out.print(arr[i]);
           System.out.print(' ');
       }
       System.out.println(' ');
   }
    public void showr(){
        for(int i = n-1; i >= 0; i--){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println(' ');
    }
    public void ran(){
        for (int i = 0; i<n;i++) {
            arr[i] = (short)(Math.random()*100);
        }
        System.out.println("Массив введен");
    }
    public void put(Scanner in){
        for (int i = 0; i<n;i++) {
            arr[i] = in.nextShort();
        }
        System.out.println("Массив введен");
    }
    public void add(short [] nums){
        for (int i = 0; i<n;i++) {
            this.arr[i] = nums[i];
        }
        System.out.println("Массив введен");
    }
    public void opr(int h){
       int sum=0;
       for(int i = 0; i< n; i++){
           int s = 2;
           for (int j = 2; j<arr[i]-1; j++) {
               if (arr[i]%j==0){
                   s++;
               }
           }
           if (h>s){
               sum++;
           }
       }
        System.out.println("количесвто элементов массива с делителем, меньшим заданного числа, = " + sum);
    }
    public mass opr2(){
       int add = 0;

       String str = "";
       int num;
        for(int i = 0; i< n; i++){
           str = Short.toString(arr[i]).substring(0,1);
           num = Integer.parseInt(str);
            if (num % 2 ==0) {

            add++;

            }

        }
        short []ar= new short[add];


        int j = 0;
        for(int i = 0; i< n; i++){
            str = Short.toString(arr[i]).substring(0,1);
            num = Integer.parseInt(str);
            if (num % 2 ==0) {
                ar[j]=arr[i];
                add++;
                j++;

            }

        }
        for (int i =0; i<ar.length;i++){

            System.out.println(ar[i]);}
        mass newmass = new mass(ar.length);
        newmass.add(ar);
        return newmass;
        /*short [] arr = new short[add];

        for (int i =0; i<ar.length;i++){
            arr[i] =ar[i];
            System.out.println(ar[i]);
        }*/

    }
}
// сделать функцию с входными данными классами и поменять одно на другое
