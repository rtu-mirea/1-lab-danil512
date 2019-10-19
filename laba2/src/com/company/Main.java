package com.company;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       boolean OK = true;

            while(OK) {
                System.out.println("Введите номер задания:\n1. String\n2. StringBuilder\n3. Регулярные выражения");
                Scanner in = new Scanner(System.in);
                int num = in.nextInt();
                switch (num){
                    case 1:
                        System.out.println("Введите номер задания:\n1. Найти сумму всех чисел текста и представит результат в десятичной системе счисления. \n2. Увеличить каждую цифру числа на 1, с учетом системы счисления. \n3. Определить, сколько чисел текста заданы в N-ричной системе счисления. \n4. Сформировать новую строку из чисел шестнадцатеричнойсистемы счисления.\n ");
                        int numz = in.nextInt();
                        text mainStr = new text("123,12/135258,10/12354358,16/1325183,16/2351,8/10111010,2");
                        switch (numz){
                            case 1:
                                System.out.println(mainStr.sum()) ;
                                break;
                            case 2:
                                mainStr.change();
                                System.out.println (mainStr.get());
                                break;
                            case 3:
                                System.out.println("Введите перове число: ");
                                int enternum1 = in.nextInt();
                                System.out.println(mainStr.get_num(enternum1));
                                break;
                            case 4:


                                System.out.println(mainStr.getstr());
                                break;

                        }
                        break;
                    case 2:
                        System.out.println("Введите номер задания:\n1. Увеличить каждую цифру числа на 1, с учетом системы счисления \n2. Заменить числа десятичной системы счисления числами шестнадцатеричной системы счисления. \n3. Добавить сумму чисел восьмеричной системы счисления в конец текста, как новое предложение.\n");
                        int numza = in.nextInt();
                        textbuilder mainStr2 = new textbuilder("123,8/135258,10/12354358,10/1325183,10/2351,8/5252,8");
                        switch (numza){
                            case 1:
                                mainStr2.change2();
                                System.out.println (mainStr2.get());
                                break;
                            case 2:
                                mainStr2.tran();
                                System.out.println (mainStr2.get());

                                break;
                            case 3:
                                mainStr2.addsumoct();
                                System.out.println (mainStr2.get());
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("Введите номер задания:\n1. Определить, что слово представляет шестнадцатеричный код числа. \n2. Удалить идущие подряд (через пробел, один или несколько) два и более одинаковых слова, причем так, чтобы не осталось пробелов\n");

                        fraze mainStr3 = new fraze("труру оао  khgklg  khgklg khgklg трам пам пам ");
                        fraze mainstr4 = new fraze("156845685a");
                        int numza3 = in.nextInt();

                        switch (numza3){
                            case 2:
                                mainStr3.repl();

                                break;
                            case 1:
                               if(mainstr4.check()==1)
                                   System.out.println("Является ");
                               else
                                   System.out.println("НЕ Является ");
                                break;
                        }

                        break;
                }
                System.out.println("Если хотите запустить программу заново нажмите 1, иначе нажмите 0: ");
                int check = in.nextInt();
                while(check != 0 || check != 1) {
                    if (check == 0) {
                        OK = false;
                        break;
                    }
                    if (check == 1) {
                        OK = true;
                        break;}
                }





            }
        }

}

