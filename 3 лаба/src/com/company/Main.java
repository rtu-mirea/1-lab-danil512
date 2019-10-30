package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        user curentuser = new user();
        boolean OK = false;
        LogisticSystem lgs = new LogisticSystem();
        Scanner in = new Scanner(System.in);
        if (!OK){
            System.out.println("Регистрация администратора");
            System.out.println("Введитте имя");
            String name = in.nextLine();
            System.out.println("Введитте login");
            String login = in.nextLine();
            System.out.println("Введитте пароль");
            String password = in.nextLine();
            System.out.println("Повторите пороль");
            String reppass = in.nextLine();

            lgs.adduser(name, login, password, reppass, 2 );
            boolean k = (lgs.finduser(password,login) == null);
            System.out.println(k);
            OK = true;
        }

        while(OK) {
            System.out.println("1 - Регистрация\n2 - Вход");

            int num = in.nextInt();
            switch (num) {
                case 1:{
                    System.out.println("1 - Регистрация водителя \n 2 - Регистрация администратора");

                    int regnum = in.nextInt();
                switch (regnum) {
                case 1: {
                    System.out.println("Введитте имя");
                    String name = in.next();
                    System.out.println("Введитте login");
                    String login = in.next();
                    System.out.println("Введитте пароль");
                    String password = in.next();
                    System.out.println("Повторите пароль");
                    String reppass = in.next();

                lgs.adduser(name, login, password, reppass, 1 );
                break;
                }
                case 2: {
                    System.out.println("Введитте имя");
                    String name = in.next();
                    System.out.println("Введитте login");
                    String login = in.next();
                    System.out.println("Введитте пароль");
                    String password = in.next();
                    System.out.println("Повторите пароль");
                    String reppass = in.next();

                    lgs.adduser(name, login, password, reppass, 2 );
                    break;
                }
                }
                }
                case 2: {

                    System.out.println("Введитте login");
                    String login = in.next();
                    System.out.println("Введитте пароль");
                    String password = in.next();

                    curentuser =lgs.finduser(login, password);

                    if (curentuser!= null){
                        int resreq = curentuser.getOption();
                        switch(resreq){
                            case 1:{
                                System.out.println("Пункт начала маршрута ");
                                String Startpoint = in.next();
                                System.out.println("Пункт назначения");
                                String destination = in.next();
                                System.out.println(lgs.findpath(Startpoint,destination));
                                break;


                            }
                            case 2:{

                                int ext = 1;
                                while (ext == 1){                               {

                                System.out.println("1 - Регистрация дороги \n2 - Регистрация пробки\n0 -  выход");
                                int registrselect= in.nextInt();
                                switch(registrselect) {
                                    case 0: {
                                    ext = 0;
                                    break;
                                    }
                                    case 1: {

                                        System.out.println("1 - пункт");
                                        String first = in.next();
                                        System.out.println("2 - пункт");
                                        String second = in.next();


                                        lgs.saveedge(first,second);
                                        break;
                                    }
                                    case 2: {

                                        System.out.println("1 - пункт");
                                        String first = in.next();
                                        System.out.println("2 - пункт");
                                        String second = in.next();
                                        System.out.println("Балл пробки.");
                                        int trafic = in.nextInt();

                                        lgs.savetrafic(first,second,trafic);

                                        break;
                                    }
                                }

                            }
                        }}
                    }
                    break;
                }
            }
        }
    }
}}
