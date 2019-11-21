package com.company;
import java.io.RandomAccessFile;
import java.io.*;

import java.io.File;

public class Filee {
    File  file;
    int size;
    public Filee(String name)throws IOException, Exception, FileNotFoundException{
        file = new File(name);
       try {
           file.createNewFile();
       } catch (IOException e) {
           e.printStackTrace();
       }

    }
    public void add(Toy smth)throws IOException, Exception, FileNotFoundException{//Перезапись
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file.getPath(),true)))
        {
            // записываем значения
            dos.writeUTF(smth.label);
            dos.writeInt(smth.age[0]);
            dos.writeInt(smth.age[1]);
            dos.writeInt(smth.price);
            size = 1;
            dos.close();

        }

    }
    public void add2(Toy smth)throws IOException, Exception, FileNotFoundException{//Запись в конец
        try(FileOutputStream dos = new FileOutputStream(file.getPath(),true))
        {
            // записываем значения
            dos.write(smth.label.getBytes());
            dos.write(smth.age[0]);
            dos.write(smth.age[1]);
            dos.write(smth.price);
            size++;
            dos.close();
        }

    }
    public String findbyname(String name)throws IOException, Exception, FileNotFoundException{//найти по имени
        try(DataInputStream dos = new DataInputStream(new FileInputStream(file.getPath())))
        {
            byte[] buffer = new byte[dos.available()];
            int i = 0;
            int age =0;
            int age2=0;
            int price=0;
            String S = "";
            String label= "";
            while(i<size) {
                label = dos.readUTF();
                age = dos.readInt();
                age2 = dos.readInt();
                price = dos.readInt();
                i++;
                if (name.equals(label))
                    S += "Производитель "+ label + " Возраст " + age + " - " + age2 +" Цена "+ price + "\n" ;
            }

            return S;
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        return null;
    }
    public void getahalf(int age)throws IOException, Exception, FileNotFoundException{   //Уменьшить вдвое цену на игрушки для детей до определенного возраста
        Toy[] mass = new Toy[size];
        try(DataInputStream dos = new DataInputStream(new FileInputStream(file.getPath())))
        {

            int i = 0;
            int age1 =0;
            int age2=0;
            int price=0;
            String S = "";
            String label= "";
            while(i<size) {
                label = dos.readUTF();
                age1 = dos.readInt();
                age2 = dos.readInt();
                price = dos.readInt();
                if (age1>= age)
                    mass[i] = new Toy(label,price,age1,age2);
                else
                    mass[i] = new Toy(label,price/2,age1,age2);

            }


        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file.getPath(),true)))
        {
            size =0;
            // записываем значения
            dos.writeUTF(mass[0].label);
            dos.writeInt(mass[0].age[0]);
            dos.writeInt(mass[0].age[1]);
            dos.writeInt(mass[0].price);
            size = 1;
            dos.close();

        }
        for (int i = 1; i<mass.length;i++){
        try(FileOutputStream dos = new FileOutputStream(file.getPath(),true))
        {
            // записываем значения
            dos.write(mass[i].label.getBytes());
            dos.write(mass[i].age[0]);
            dos.write(mass[i].age[1]);
            dos.write(mass[i].price);
            size++;
            dos.close();
        }
        }

    }


    public String get()throws IOException, Exception, FileNotFoundException{ //распечатать файл
         try(DataInputStream dos = new DataInputStream(new FileInputStream(file.getPath())))
        {
            byte[] buffer = new byte[dos.available()];
            int i = 0;
            int age =0;
            int age2=0;
            int price=0;
            String S = "";
            String label= "";
            while(i<size) {
                 label = dos.readUTF();
                 age = dos.readInt();
                 age2 = dos.readInt();
                 price = dos.readInt();
                 i++;
                 S += "Производитель "+ label + " Возраст " + age + " - " + age2 +" Цена "+ price + "\n" ;
            }

           return S;
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        return null;
    }




    public String get1() throws IOException {//вывести файл RandomAccessFile
        RandomAccessFile raf = new RandomAccessFile("file.txt", "r");

        raf.seek(0);
        String text1 = raf.readLine();
        raf.close();
        return text1;
    }
    public void add(int i,Toy smth) throws IOException {//вставить в определенное место файла RandomAccessFile
        RandomAccessFile raf = new RandomAccessFile("file.txt", "r");

        raf.seek(i*42);
        String text1 = raf.readLine();
        raf.close();
        RandomAccessFile raf1 = new RandomAccessFile("file.txt", "rw");
        raf1.seek(i*42);
        raf.writeBytes(("label: "+ smth.label));
        raf.writeBytes(" Age:  " );
        raf.writeBytes(String.valueOf(smth.age[0]));
        raf.writeBytes(" - ");
        raf.writeBytes(String.valueOf(smth.age[1]));
        raf.writeBytes(" Prise: ");
        raf.writeBytes(String.valueOf(smth.price));
        raf.writeBytes(text1);


    }

    public void add3(Toy smth) throws IOException{//добавить в конец RandomAccessFile
        RandomAccessFile raf = new RandomAccessFile("file.txt", "rw");
        raf.seek(raf.length());
        raf.writeBytes(("label: "+ smth.label));
        raf.writeBytes(" Age:  " );
        raf.writeBytes(String.valueOf(smth.age[0]));
        raf.writeBytes(" - ");
        raf.writeBytes(String.valueOf(smth.age[1]));
        raf.writeBytes(" Prise: ");
        raf.writeBytes(String.valueOf(smth.price));
        raf.close();

    }

}
