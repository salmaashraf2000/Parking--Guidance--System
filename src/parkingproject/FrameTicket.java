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

public class FrameTicket extends JFrame{
    JLabel l1,l2,l3,l4,l5,l6;
    
    FrameTicket(int ticketid,String arrive,String date,String opname,int idspot,String sdescription){
        setSize(580,350);                 
        setResizable(false);
        setVisible(true);
        setLayout(null); 
        setTitle("Ticket");
        JLabel background = new JLabel(new ImageIcon("E:\\pp.png"));
        add(background); 
        background.setLayout(null);
        background.setSize(578,313);
        l1 = new JLabel("Ticket Id        : "+ticketid);
        l2= new JLabel("Arrival time     : "+arrive);
        l3= new JLabel("Date             : "+date);
        l4 = new JLabel("Operator name    : "+opname);
        l5= new JLabel("Spot ID          : "+idspot);
        l6= new JLabel("Spot description:  "+sdescription);
       
        background.add(l1);
        background.add(l2);
        background.add(l3);
        background.add(l4);
        background.add(l5);
        background.add(l6);
       
        l1.setFont(new Font("Verdana", Font.BOLD, 18)); 
       l1.setSize(420, 20); 
        l1.setLocation(150, 10); 
        
         l2.setFont(new Font("Verdana",  Font.BOLD, 18)); 
       l2.setSize(420, 20); 
        l2.setLocation(150, 50); 
        
         l3.setFont(new Font("Verdana", Font.BOLD, 18)); 
       l3.setSize(420, 20); 
        l3.setLocation(150, 90); 
        
         l4.setFont(new Font("Verdana",  Font.BOLD, 18)); 
       l4.setSize(420, 20); 
        l4.setLocation(150, 130); 
        
         l5.setFont(new Font("Verdana", Font.BOLD, 18)); 
       l5.setSize(420, 20); 
        l5.setLocation(150, 170); 
        
         l6.setFont(new Font("Verdana",Font.BOLD, 18)); 
       l6.setSize(420, 20); 
        l6.setLocation(150, 210);
        
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    }
}
