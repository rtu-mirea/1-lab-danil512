package com.company;
import java.util.ArrayList;

public class LogisticSystem {
 private  Map map = new Map();
 private ArrayList<user> users = new ArrayList<user>();


 public void adduser(String Name, String password, String login, String repeation,int type){

  if(password.equals(repeation)){

   if(type == 1){
    driver driv = new driver(Name,login,password);
    users.add(driv);
   }
   if(type == 2){
    admin administr = new admin(Name,login,password);
    users.add(administr);
  }

 }

 }
 public user finduser(String password, String login){
  for (int i = 0; i< users.size();i++){
   if (users.get(i).enter(login,password)){
    return users.get(i);
   }
  }
   return null;

 }
 public void saveedge (String place1,String place2){
  map.addEdge(place1,place2,5);
 }
 public void savetrafic (String place1,String place2, int trafic_k){
  map.addBackypInfo(place1,place2,trafic_k);
 }

 public String findpath(String place1,String place2 ){
  return map.generatepath(place1,place2);

 }

 }





