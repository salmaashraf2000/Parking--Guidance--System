/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingproject;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author metr
 */
public class FrameInfoTicket extends JFrame{
      JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    
    FrameInfoTicket(int ticketid,String arrive,String dep,int money,String date,String opname,int idspot,String sdescription,String cst,String plate){
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
        l3= new JLabel("Departure time   : "+dep);
        l4= new JLabel("Paid Money       :  "+money);
        l5= new JLabel("Date             : "+date);
        l6 = new JLabel("Operator name    : "+opname);
        l7= new JLabel("Spot ID          : "+idspot);
        l8= new JLabel("Spot description:  "+sdescription);
        l9= new JLabel("Customer name    : "+cst);
        l10= new JLabel("Plate Number     :  "+plate);
        
        background.add(l1);
        background.add(l2);
        background.add(l3);
        background.add(l4);
        background.add(l5);
        background.add(l6);
         background.add(l7);
        background.add(l8);
        background.add(l9);
        background.add(l10);
       
        l1.setFont(new Font("Verdana", Font.BOLD, 15)); 
       l1.setSize(420, 20); 
        l1.setLocation(150, 10); 
        
         l2.setFont(new Font("Verdana",  Font.BOLD, 15)); 
       l2.setSize(420, 20); 
        l2.setLocation(150, 30); 
        
         l3.setFont(new Font("Verdana", Font.BOLD, 15)); 
       l3.setSize(420, 20); 
        l3.setLocation(150, 50); 
        
         l4.setFont(new Font("Verdana",  Font.BOLD, 15)); 
       l4.setSize(420, 20); 
        l4.setLocation(150, 70); 
        
         l5.setFont(new Font("Verdana", Font.BOLD, 15)); 
       l5.setSize(420, 20); 
        l5.setLocation(150, 90); 
        
         l6.setFont(new Font("Verdana",Font.BOLD, 15)); 
       l6.setSize(420, 20); 
        l6.setLocation(150, 110);
        
         l7.setFont(new Font("Verdana", Font.BOLD, 15)); 
       l7.setSize(420, 20); 
        l7.setLocation(150, 130); 
        
         l8.setFont(new Font("Verdana",  Font.BOLD, 15)); 
       l8.setSize(420, 20); 
        l8.setLocation(150, 150); 
        
         l9.setFont(new Font("Verdana", Font.BOLD, 15)); 
       l9.setSize(420, 20); 
        l9.setLocation(150, 170); 
        
         l10.setFont(new Font("Verdana",Font.BOLD, 15)); 
       l10.setSize(420, 20); 
        l10.setLocation(150, 190);
        
     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
