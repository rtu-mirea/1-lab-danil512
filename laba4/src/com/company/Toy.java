package com.company;

public class Toy {//Класс игрушек для №2
    String label;
    int price;
    int[] age = new int[2];
    public Toy(String label, int price, int low_edge, int top_edge){
        this.label = label;
        this.price = price;
        age[0] = low_edge;
        age[1] = top_edge;
    }
    public int compare(Toy sub){
        if (sub.age ==this.age){

            return 1;

        }
        return 0;
    }
    public String get( int low_edge, int top_edge){
        if ((this.age[0] == low_edge) && (this.age[1]==top_edge))
            return this.label + ' ' + this.price;
        return "Ошибка";

    }

}
