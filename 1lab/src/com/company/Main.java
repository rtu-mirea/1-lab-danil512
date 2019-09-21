package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите количество элементов массива");
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        mass m = new mass(k);
	    int a =0;
	    while (a!=9){

            System.out.println("1 - ввести вручную");
            System.out.println("2 - автозаполнение");
            System.out.println("3 - вывод п-л");
            System.out.println("4 - вывод л-п");
            System.out.println("5 - func1");
            System.out.println("6 - func2");
            a = in.nextInt();
            if (a==1){
                m.put(in);
            }
            if (a==2){
                m.ran();
            }
            if (a==3){
                m.showr();
            }
            if (a==4){
                m.showl();
            }
            if (a==5){
                int kl = in.nextInt();
                System.out.println("Введите число для сравнения.");
                m.opr(kl);
            }
            if (a==6){

                m.opr2();
            }
    }
    }
}
