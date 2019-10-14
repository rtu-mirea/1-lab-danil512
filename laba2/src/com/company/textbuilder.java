package com.company;

import java.util.Arrays;

public class textbuilder {
    StringBuilder str;
    public textbuilder(String n){
        str = new StringBuilder(n);
    }


    public String get() {
    return str.toString();
    }

    public void addsumoct(){
        int x, n, sys;
        int S = 0;
        String str1 = str.toString();

        String[] words = str1.split("/");
        for (int i = 0; i<words.length; i++){
            n = words[i].indexOf(',');
            String numb = words[i].substring(0, n);
            String Sys1 = words[i].substring(n + 1, words[i].length());
            sys=Integer.parseInt(Sys1);

            if (sys == 8){
                x = Integer.parseInt(numb,8);
                S+=x;
            }

        }
        str.append("/"+Integer.toString(S, 8)+ ",8");




    }

    public void tran(){
        int x, n, sys;

        String[] words = str.toString().split("/");
        for (int i = 0; i<words.length; i++){
            n = words[i].indexOf(',');
            String numb = words[i].substring(0, n);
            String Sys1 = words[i].substring(n + 1, words[i].length());
            sys=Integer.parseInt(Sys1);
            x = Integer.parseInt(numb);
            if (sys == 10){
                numb = Integer.toString(x, 16);
            }
            words[i] = numb + ","+ "16";

        }
        str = new StringBuilder(Arrays.toString(words));




    }
    public void change2(){
        int j = 0;
        int per = 0;
        int newx = 0;
        int x;
        int sys;
        int n;
        int flag = 0;
        String[] words = str.toString().split("/");
        str.setLength(0);
        for (int i = 0; i < words.length; i++) {

            n = words[i].indexOf(',');
            String numb = words[i].substring(0, n);
            String Sys1 = words[i].substring(n + 1, words[i].length());
            sys=Integer.parseInt(Sys1);
            x = Integer.parseInt(numb);
            j=0;
            per = 0;
            newx =0;
            while (x>0){
                if (1+x%10<sys) {
                    per = 1 + x % 10;
                    flag = 0;
                }
                else {
                    per = 0;
                    flag =1;
                }
                newx += per * Math.pow(10,j)+ flag *Math.pow(10,j+1);
                j++;
                x/=10;
            }
            words[i] = Integer.toString(newx)+','+Sys1;
            str.append(words[i]+"/");

        }

    }
}
