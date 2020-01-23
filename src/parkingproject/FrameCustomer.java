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
import java.sql.*;
import java.util.*;
        

public class FrameCustomer extends JFrame implements ActionListener{
    JFrame frame ;
    JButton gett;
    JLabel title;
    JLabel name;
    JTextField tname ;
    JLabel number;
    JTextField tnum;
    JPanel Customer;
    Customer c;
    
    public FrameCustomer()
    {
        JLabel background;
        c= new Customer();   
        setTitle("Customer");
        setSize(800,560);                 
        setResizable(false);
        setVisible(true);
        setLayout(null);   
        background = new JLabel(new ImageIcon("C:\\Users\\metr\\Documents\\NetBeansProjects\\ParkingProject\\06_parking_total_autonomia.jpg"));
        add(background); 
        background.setLayout(null);
        background.setSize(800,560); 
        background.setLayout(null);
        background.setSize(800,560);
        Customer=new JPanel();
        name= new JLabel ("Name");
        tname = new JTextField(); 
        number = new JLabel("Plate Number"); 
        tnum = new JTextField(); 
        gett= new JButton("Get Ticket");
        title = new JLabel("Please Enter Your Information To Get Ticket");
        gett= new JButton("Get Ticket");
        background.add(title);
        background.add(name);
        background.add(tname);
        background.add(number); 
        background.add(tnum); 
        background.add(gett);
        Customer.setLayout(null);
           
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(600, 30); 
        title.setLocation(100, 50); 
        title.setForeground(Color.white);
           
          
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(100, 30); 
        name.setLocation(200, 150); 
        name.setForeground(Color.white); 
        
          
        tname.setSize(190, 20); 
        tname.setLocation(350, 160); 
             
           
       
        number.setFont(new Font("Arial", Font.PLAIN, 20)); 
        number.setSize(200, 20); 
        number.setLocation(200, 250); 
        number.setForeground(Color.white);
  
       
        tnum.setSize(190, 20); 
        tnum.setLocation(350, 250); 
        
        
       
        gett.setSize(100,25);
        gett.setLocation(360, 350);
         
        gett.addActionListener(this);  
          
            
       
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       }
    
       public void actionPerformed(ActionEvent e){
           
            if(e.getSource().equals(gett))
            {
                String name=tname.getText();
                String numb=tnum.getText();
                int totest=0;
                
                if (!name.isEmpty() && !numb.isEmpty() && !(name.trim().isEmpty()) && !(numb.trim().isEmpty()))
                {
                    totest=c.printTicket(name, numb);
                    
                    if (totest==0)
                    {
                      JOptionPane.showMessageDialog(gett, "Sorry No Place For Parking","Print Ticket",JOptionPane.PLAIN_MESSAGE);
                     
                    }else
                    {
                      int tid=totest;  
                      int ticketid=0,idspot=0;
                      String arrive=null,date=null,opname=null,sdescription=null;
                      try{
                          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                          Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
                          Statement st = con.createStatement();
                          String sql= "SELECT t.idticket,t.arrivalTime,t.dateTicket,op.operatorName,t.iDspot,s.spot_description FROM Ticket as t INNER JOIN operators as op on t.idoperator1=op.idoperator INNER JOIN Spot as s on t.iDspot=s.idspot WHERE t.idticket='"+tid+"'";
                          ResultSet rs=st.executeQuery(sql);
                          
                          while (rs.next()) 
                          {
                             ticketid=rs.getInt(1);
                             arrive=rs.getString(2);
                             date=rs.getString(3);
                             opname=rs.getString(4);
                             idspot=rs.getInt(5);
                             sdescription=rs.getString(6);
                           }
                           new FrameTicket(ticketid,arrive,date,opname,idspot,sdescription);
                           
                    }catch(Exception e1){
                        
                      System.out.println(e1);
                      
                     } 
                  }
                }else
                {
                  JOptionPane.showMessageDialog(gett, "Please Enter all Information","Print Ticket",JOptionPane.PLAIN_MESSAGE);

                }
          }
      }
    
   
  
  
}
