package com.company;

import java.lang.reflect.Array;
import java.util.Scanner;
import   java.util.Arrays;

public class mass {
   private short[] a;
   private int n;

   public mass(int n){
       this.n = n;
       a = new short[n];
   }
   public void showl(){
       for(int i = 0; i < n; i++){
           System.out.print(a[i]);
           System.out.print(' ');
       }
       System.out.println(' ');
   }
    public void showr(){
        for(int i = n-1; i >= 0; i--){
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println(' ');
    }
    public void ran(){
        for (int i = 0; i<n;i++) {
            a[i] = (short)(Math.random()*100);
        }
        System.out.println("Массив введен");
    }
    public void put(Scanner in){
        for (int i = 0; i<n;i++) {
            a[i] = in.nextShort();
        }
        System.out.println("Массив введен");
    }
    public void opr(int h){
       int sum=0;
       for(int i = 0; i< n; i++){
           int s = 2;
           for (int j = 2; j<a[i]-1; j++) {
               if (a[i]%j==0){
                   s++;
               }
           }
           if (h>s){
               sum++;
           }
       }
        System.out.println("количесвто элементов массива с делителем, меньшим заданного числа, = " + sum);
    }
    public void opr2(){


       String cha = "";
       int prom;
        for(int i = 0; i< n; i++){
           cha = Short.toString(a[i]).substring(0,1);
           prom = Integer.parseInt(cha);
            if (prom % 2 !=0) {

                a[i]= 0;

            }


        }
    }
}
