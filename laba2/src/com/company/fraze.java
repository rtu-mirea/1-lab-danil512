package com.company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fraze {
    String str;
    public fraze(String n){
        str = n;
    }


    public void check(){
        Pattern pattern = Pattern.compile("\\s*([a-f0-9]*)\\s*");
        Matcher matcher = pattern.matcher(str);
        boolean found = matcher.matches();
        if(found)
            System.out.println("данное число является - 16-ичный код ");
        else
            System.out.println("данное число является - не 16-ичный код");
    }
    public void repl(){

        Pattern pattern = Pattern.compile("\\s*[a-z]+\\s*");
        String[] words = str.split("\\s+");
        boolean found ;
        String newstr = "";
        for (int i = 0; i < words.length-1; i++) {
            Matcher matcher = pattern.matcher(words[i]);
            found= matcher.matches();

            if (!(found&&(words[i].equals(words[i+1])))) {
                newstr += words[i]+ " ";

            }

        }

        newstr += words[words.length-1];
        str = newstr;
        System.out.println(str);
    }
}
