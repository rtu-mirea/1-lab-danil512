package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите количество элементов массива");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        mass m = new mass(n);
	    int answer =0;
	    while (answer!=9){

            System.out.println("1 - ввести вручную");
            System.out.println("2 - автозаполнение");
            System.out.println("3 - вывод п-л");
            System.out.println("4 - вывод л-п");
            System.out.println("5 - func1");
            System.out.println("6 - func2");
            System.out.println("9 - exit");
            answer = in.nextInt();
            if (answer==1){
                m.put(in);
            }
            if (answer==2){
                m.ran();
            }
            if (answer==3){
                m.showr();
            }
            if (answer==4){
                m.showl();
            }
            if (answer==5){

                System.out.println("Введите число для сравнения.");
                int num = in.nextInt();
                m.opr(num);
            }
            if (answer==6){

               m = m.opr2();
            }
    }
    }
}
