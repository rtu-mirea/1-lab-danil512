package com.company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fraze {
    String str;
    Pattern pattern1 = Pattern.compile("\\s*([a-f0-9]*)\\s*");
    Pattern pattern = Pattern.compile("\\s*[a-z]+\\s*");
    
    public fraze(String n){
        str = n;

    }


    public int check(){

        Matcher matcher = pattern1.matcher(str);
        boolean found = matcher.matches();
        if(found)
            return 1;
        else
            return 0;
    }
    public void repl(){


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
