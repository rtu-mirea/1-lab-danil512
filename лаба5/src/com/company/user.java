package com.company;

public class user {
    protected String Name;
    protected String Login;
    protected String Password;
    protected int option;
    public   user(){}
    public   user(String Name, String Login, String Password){
        this.Name=Name;
        this.Login=Login;
        this.Password=Password;
    }
    public boolean enter(String Login, String Password){
        if (this.Login.equals(Login)&&this.Password.equals(Password)) {
            return true;
        }
        return false;
    }
    public int getOption(){
        return option;
    }
}
