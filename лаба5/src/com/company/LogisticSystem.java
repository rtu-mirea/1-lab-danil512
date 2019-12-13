package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LogisticSystem {
 private Map map = new Map();
 private ArrayList<user> users = new ArrayList<user>();


 public void start() {
  GuiUser ui = new GuiUser();

 }
 public void switchbtw(boolean x1, boolean x2, boolean x3) {
  if (x1 == x2 && x2 == x3&& x3 == false){
   start();
  }
  if (x1 == true && x2 == false&& x3 == false)
  {
   GuiUser ui = new GuiUser(true);
  }
  if (x1 == true && x2 == true&& x3 == false)
  {
   GuiUser ui = new GuiUser(true,true);
  }
 }
 public void adduser(String Name, String password, String login, String repeation, int type) {

  if (password.equals(repeation)) {

   if (type == 1) {
    driver driv = new driver(Name, login, password);
    users.add(driv);
   }
   if (type == 2) {
    admin administr = new admin(Name, login, password);
    users.add(administr);
   }

  }

 }

 public user finduser(String password, String login) {
  for (int i = 0; i < users.size(); i++) {
   if (users.get(i).enter(login, password)) {
    return users.get(i);
   }
  }
  return null;

 }

 public void saveedge(String place1, String place2) {
  map.addEdge(place1, place2, 5);
 }

 public void savetrafic(String place1, String place2, int trafic_k) {
  map.addBackypInfo(place1, place2, trafic_k);
 }

 public String findpath(String place1, String place2) {
  return map.generatepath(place1, place2);
 }

 //==============================================================================================================\\
 public class GuiUser extends JFrame {
  /*Элементы для входа*/
  private JLabel label_name = new JLabel("Имя: ");
  private JTextField name = new JTextField(25);
  private JLabel label_login = new JLabel("Логин: ");
  private JTextField login = new JTextField(25);
  private JLabel label_password = new JLabel("пароль");
  private JPasswordField password = new JPasswordField(23);
  private JButton signIn = new JButton("Вход");
  private JButton goto_signUp = new JButton("Регистрация");


  /*администратор*/
  private JLabel label_start = new JLabel("Пункт 1: ");
  private JTextField start = new JTextField(25);
  private JLabel label_fin = new JLabel("Пункт 2: ");
  private JTextField fin = new JTextField(25);
  private JLabel label_traffic = new JLabel("Пробка");
  private JTextField traffic = new JTextField(23);
  private JButton set_traff = new JButton("установить пробку");
  private JButton set_road = new JButton("установить дорогу");
  private JButton exit = new JButton("exit");

  /*Марщрут*/
  private JLabel label_start1 = new JLabel("Пункт 1: ");
  private JTextField start1 = new JTextField(25);
  private JLabel label_fin1 = new JLabel("Пункт 2: ");
  private JTextField fin1 = new JTextField(25);
  private JTextArea mapline = new JTextArea();
  private JLabel label_mapline = new JLabel("Маршрут");
  private JButton makepath = new JButton("установить дорогу");



  /*Стартовая страница*/
  public GuiUser() {
   super("Start page");
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   name.setHorizontalAlignment(JTextField.LEFT);
   login.setHorizontalAlignment(JTextField.LEFT);
   password.setHorizontalAlignment(JTextField.LEFT);

   name.setFont(new Font("TimesNewRoman", Font.PLAIN, 14));
   login.setFont(new Font("TimesNewRoman", Font.PLAIN, 14));

   JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
   contents.add(label_name);
   contents.add(name);
   contents.add(label_login);
   contents.add(login);
   contents.add(label_password);
   contents.add(password);
   contents.add(signIn);
   contents.add(goto_signUp);


   ActionListener open_new_win = new OpenRegistrationWindow();
   goto_signUp.addActionListener(open_new_win);

   ActionListener entrance = new OpenEntry();
   signIn.addActionListener(entrance);



   setSize(370, 160);
   setContentPane(contents);
   setVisible(true);
  }


  public GuiUser(boolean x1) {
   super("Администрирование");
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   start.setHorizontalAlignment(JTextField.LEFT);
   fin.setHorizontalAlignment(JTextField.LEFT);
   traffic.setHorizontalAlignment(JTextField.LEFT);

   start.setFont(new Font("TimesNewRoman", Font.PLAIN, 14));
   fin.setFont(new Font("TimesNewRoman", Font.PLAIN, 14));

   JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
   contents.add(label_start);
   contents.add(start);
   contents.add(label_fin);
   contents.add(fin);
   contents.add(label_traffic);
   contents.add(traffic);
   contents.add(set_road);
   contents.add(set_traff);
   contents.add(exit);



   ActionListener make_road1 = new make_road();
   set_road.addActionListener(make_road1);

   ActionListener settref = new trf();
   set_traff.addActionListener(settref);
   ActionListener ex = new tobegin();
   exit.addActionListener(ex);



   setSize(400, 200);
   setContentPane(contents);
   setVisible(true);
  }


  public GuiUser(boolean x1, boolean x2) {
   super("приложение так себе");
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   start1.setHorizontalAlignment(JTextField.LEFT);
   fin1.setHorizontalAlignment(JTextField.LEFT);

   start1.setFont(new Font("TimesNewRoman", Font.PLAIN, 14));
   fin.setFont(new Font("TimesNewRoman", Font.PLAIN, 14));

   JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
   contents.add(label_start1);
   contents.add(start1);
   contents.add(label_fin1);
   contents.add(fin1);
   contents.add(label_mapline);
   contents.add(mapline);
   contents.add(makepath);
   contents.add(exit);



   ActionListener make_path = new mk();
   makepath.addActionListener(make_path);

   ActionListener ex = new tobegin();
   exit.addActionListener(ex);



   setSize(380, 200);
   setContentPane(contents);
   setVisible(true);
  }
  public class OpenRegistrationWindow implements ActionListener {
   public void actionPerformed(ActionEvent e) {

    String lo = login.getText();
    String na = name.getText();
    String pas = password.getText();
    driver d = new driver(na, lo, pas);
    users.add(d);
    System.out.println(users.get(users.size()-1).Name);

   }
  }

  public class OpenEntry implements ActionListener {
   public void actionPerformed(ActionEvent e) {


    String lo = login.getText();
    String na = name.getText();
    String pas = password.getText();
    user cur = finduser(pas,lo);
    if (cur!= null&&cur.option == 2) {
     switchbtw(true, false, false);
     setVisible(false);
    }
    if (cur!= null&&cur.option == 1){
     switchbtw(true, true, false);
     setVisible(false);
    }
   }
  }
  public class make_road implements ActionListener {
   public void actionPerformed(ActionEvent e) {

    String p1 = start.getText();
    String p2 = fin.getText();
    saveedge(p1,p2);

   }
  }
  public class trf implements ActionListener {
   public void actionPerformed(ActionEvent e) {

    String p1 = start.getText();
    String p2 = fin.getText();
    int trf = Integer.parseInt(traffic.getText());
    savetrafic(p1,p2,trf);

   }
  }
  public class mk implements ActionListener {
  public void actionPerformed(ActionEvent e) {

   String p1 = start1.getText();
   String p2 = fin1.getText();

   String  g = findpath(p1,p2);
   mapline.append(g);
  }
 }
  public class tobegin implements ActionListener {
   public void actionPerformed(ActionEvent e) {
    setVisible(false);
    switchbtw(false,false,false);
   }
  }

 }


}

