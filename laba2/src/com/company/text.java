package com.company;

public class text {
    private  String str;
    public text(String n){
        str = n;
    }

    public String get() {
     return str;
    }

    public void change(){
        int j = 0;
        int per = 0;
        int newx = 0;
        int x;
        int sys;
        int n;
        String[] words = str.split("/");
        str = "";
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
               if (1+x%10<sys)
                   per = 1+x%10;
               else
                   per = 0;
               newx += per * Math.pow(10,j);
               j++;
               x/=10;
           }
           words[i] = Integer.toString(newx)+','+Sys1+"/";
            str+=words[i];

        }

    }



    public String getstr(){
        String S="";
        int sys;
        int n;
        String[] words = str.split("/");
        for (int i = 0; i < words.length; i++) {

            n = words[i].indexOf(',');
            String numb = words[i].substring(0, n);
            String Sys1 = words[i].substring(n + 1, words[i].length());
            sys=Integer.parseInt(Sys1);
            if (sys ==16)
               S+=numb+' ';
        }
        return S;
    }
    public int get_num(int Sys){
        int S=0;
        int sys;
        String[] words = str.split("/");
        for (int i = 0; i < words.length; i++) {

        int n = words[i].indexOf(',');
        String Sys1 = words[i].substring(n + 1, words[i].length());
        sys=Integer.parseInt(Sys1);
        if (sys ==Sys)
            S+=1;
        }
        return S;
    }
    public int sum() {
        int S = 0;

        String[] words = str.split("/");
        for (int i = 0; i < words.length; i++) {

            int decx = 0;
            int x;
            int xost;
            int miltipl;
            int n = words[i].indexOf(',');

            String numb = words[i].substring(0, n);

            String Sys = words[i].substring(n + 1, words[i].length());

            miltipl=Integer.parseInt(Sys);

            if  (miltipl == 10){
                S+=Integer.parseInt(numb); }
            else{
                x = Integer.parseInt(numb);
                int j = 0;

                while (x>0) {
                    xost = x % 10;
                    decx += xost * Math.pow(miltipl, j);
                    x/=10;
                    j++;
                }

            S+=decx;
        }
    }
        return S;
    }
}


