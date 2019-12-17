/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingproject;

/**
 *
 * @author metr
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class BackgroundImageJFrame extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5;
    JButton b1,b2;
    TextField t1;
    JPasswordField p1;
    JComboBox c1;
    Admin ad;
    Operator op;
    public BackgroundImageJFrame(){
        String[] role = {"Admin","Operator"};
        setTitle("Login");
        setSize(800,560);                 //set size of frame w l
        setResizable(false);
        setVisible(true);
        setLayout(null);
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\metr\\Pictures\\Saved Pictures\\06_parking_total_autonomia.jpg"));
        add(background); 
        background.setLayout(null);
        background.setSize(800,560);
        l1 = new JLabel("Login");
        l2= new JLabel("ID:");
        l3= new JLabel("Password:");
        b1=new JButton("Sign in");
        t1= new TextField();
        p1= new JPasswordField();
        l4= new JLabel("Are you a customer ? Then click here");
        c1= new JComboBox(role);
        l5= new JLabel("Role:");
        b2=new JButton("Click Here");
        background.add(l1);
        background.add(l2);
        background.add(l3);
        background.add(b1);
        background.add(t1);
        background.add(p1);
        background.add(l4);
        background.add(c1);
        background.add(l5);
        background.add(b2);
        l1.setBounds(370,10,200,80);
        l1.setFont(new Font("Serif", Font.BOLD, 35));
        l1.setForeground(Color.white);
        l2.setBounds(200,70,100,80);
        l2.setFont(new Font("Serif", Font.BOLD, 17));
        l2.setForeground(Color.white);
        l3.setBounds(200,120,200,80);
        l3.setFont(new Font("Serif", Font.BOLD, 17));
        l3.setForeground(Color.white);
        p1.setBounds(300,150,180,20);
        b1.setBounds(350,270,89,23);
        b1.addActionListener(this);  
        t1.setBounds(300,100,180,20);
        l4.setBounds(150,300,490,80);
        l4.setFont(new Font("Serif", Font.BOLD, 30));
        l4.setForeground(Color.white);
        c1.setBounds(300,210,180,20);
        c1.setSelectedIndex(0);
        l5.setBounds(200,180,100,80);
        l5.setFont(new Font("Serif", Font.BOLD, 17));
        l5.setForeground(Color.white);
        b2.setBounds(345,380,100,23);
         b2.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String id=t1.getText();
        String pass=p1.getText();
        String combovalue = (String)c1.getSelectedItem();
       /* boolean incorrect = true;
          while(incorrect){
           try{
               Integer.parseInt(id);
               incorrect = false;
           }
              catch(NumberFormatException formate){
          id=JOptionPane.showInputDialog("Invalid input.please enter a number without spaces");
          }

        }        */  
        if(e.getSource().equals(b1)){
            boolean incorrect = true;
          while(incorrect){
           try{
               Integer.parseInt(id);
               incorrect = false;
           }
              catch(NumberFormatException formate){
          id=JOptionPane.showInputDialog("Invalid input.please enter a number without spaces");
          }

        }   
           if(combovalue=="Admin" && !id.isEmpty() && !pass.isEmpty() && !(id.trim().isEmpty()) && !(pass.trim().isEmpty())){
           
              ad=new Admin();  
              if((ad.login(Integer.valueOf(id),pass))==1){
                  JOptionPane.showMessageDialog(this,"Logged in successfully");
                  //frame of admin
                  setVisible(false);
                  new FrameAdmin();
                  
              }else{
                  JOptionPane.showMessageDialog(this,"Wrong Id or Password");
              }
           
 
           }else if(combovalue=="Operator" && !id.isEmpty() && !pass.isEmpty() && !(id.trim().isEmpty()) && !(pass.trim().isEmpty())){
             op=new Operator();  
              if((op.login(Integer.valueOf(id),pass))==1){
                  JOptionPane.showMessageDialog(this,"Logged in successfully");
                  //frame of operator
                  setVisible(false);
                  new FrameOperator();
              }else{
                  JOptionPane.showMessageDialog(this,"Wrong Id or Password");
              }
        
           }else{
                JOptionPane.showMessageDialog(this,"Please enter all in formation");
           }
        }else if(e.getSource().equals(b2)){
           //frame of customer
            setVisible(false);
           new FrameCustomer();
        }
    }
}
