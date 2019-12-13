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

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
public class FrameOperator /*extends JFrame*/ implements ActionListener{
  
       Operator op =new Operator();
        Customer c= new Customer();
          JFrame jf;
          JTabbedPane tabbedPane;
          JLabel label,tit,Id , titl,IdS,titleS;
          JTextField tid,tidcheck,tidfree;
          JPanel  panel2, panel3,panel1,panel4,panel5;
          JButton b1;
           JTable table; 
           JTable table1;
           JButton calcmoney ,check,free;
            JScrollPane scrollpane =new JScrollPane();
          FrameOperator(){     
          jf=new JFrame();     
          jf.setTitle("Operator"); 
          jf.setResizable(false);
          
        
          
          tabbedPane = new JTabbedPane();
      JTabbedPane tabbedPane = new JTabbedPane();
      panel1 = new JPanel();//////////////
      panel2 = new JPanel();
      panel3 = new JPanel();
      panel4 = new JPanel();
      table = new JTable();
      table1 =new JTable();
      panel4.setLayout(null);
        panel5=new JPanel();
        panel5.setLayout(null);
    // panel2.setLayout(null);
     
     
     
      b1=new JButton("Log out");
      b1.addActionListener(this); 
      
    tit = new JLabel("Calculate Money"); 
        tit.setFont(new Font("Arial", Font.PLAIN, 30)); 
        tit.setSize(300, 30); 
        tit.setLocation(250, 30); 
         panel4.add(tit);
  
        Id= new JLabel("ID Of Ticket"); 
        Id.setFont(new Font("Arial", Font.PLAIN, 20)); 
        Id.setSize(150, 20); 
        Id.setLocation(180, 150); 
        panel4.add(Id); 
  
        tid = new JTextField(); 
        tid.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tid.setSize(190, 20); 
        tid.setLocation(300, 150); 
        panel4.add(tid); 
        
       calcmoney =new JButton("Get Money");
            calcmoney.setSize(100, 20); 
        calcmoney.setLocation(300, 200); 
        panel4.add(calcmoney);
        
        
        
        titl = new JLabel("Show Ticket Information"); 
        titl.setFont(new Font("Arial", Font.PLAIN, 30)); 
        titl.setSize(370, 30); 
        titl.setLocation(250, 30); 
         panel5.add(titl);
         
         
        Id= new JLabel("ID Of Ticket"); 
        Id.setFont(new Font("Arial", Font.PLAIN, 20)); 
        Id.setSize(150, 20); 
        Id.setLocation(180, 150); 
        panel5.add(Id); 
  
        tidcheck = new JTextField(); 
        tidcheck.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tidcheck.setSize(190, 20); 
        tidcheck.setLocation(300, 150); 
        panel5.add(tidcheck); 
        
       check =new JButton("Search");
            check.setSize(100, 20); 
        check.setLocation(300, 200); 
        panel5.add(check);
        
        
      label = new JLabel("To Log out Click Here"); 
      tabbedPane.addTab("Calculate Money", panel4);
      tabbedPane.addTab("View All Slots", panel1);
      tabbedPane.addTab("View Free Spots ", panel2);
      tabbedPane.addTab("Search For Ticket", panel5);
      tabbedPane.addTab("Log out", panel3);
      panel3.setLayout(null);
        jf.add(tabbedPane);
        panel3.add(label);
        panel3.add(b1);
       
      label.setBounds(280,10,300,80);
      label.setFont(new Font("Serif", Font.BOLD, 25));
      b1.setBounds(365,150,80,40);
      
      
      calcmoney.addActionListener(new ActionListener(){ // button Calculate Money
                @Override
                public void actionPerformed(ActionEvent ae) {
                   String iD  = tid.getText();
                    boolean incorrect = true;
                    while(incorrect){
                      try{
                       Integer.parseInt(iD);
                       incorrect = false;
                      }
                      catch(NumberFormatException formate){
                      iD=JOptionPane.showInputDialog("Invalid input.please enter a number");
                      }

                    }   
                   int totest=c.pay(Integer.valueOf(iD));
                    if(iD.isEmpty() || (iD.trim().isEmpty()) ) {
                        JOptionPane.showMessageDialog(calcmoney, "Please Enter the ID of Ticket","Calculate Money",JOptionPane.PLAIN_MESSAGE);
                    }else if(totest==0){
                            JOptionPane.showMessageDialog(calcmoney, "ERROR ID does not exist" ,"Calculate Money",JOptionPane.ERROR_MESSAGE );

                    }else{
                         JOptionPane.showMessageDialog(calcmoney, "Customer Should Pay"+totest+"LE" ,"Calculate Money",JOptionPane.PLAIN_MESSAGE );
                    }
                    tid.setText("");
                }});
      
      check.addActionListener(new ActionListener(){ // button Calculate Money
                @Override
                public void actionPerformed(ActionEvent ae) {
                   String iDc  = tidcheck.getText();
                    boolean incorrect = true;
                    while(incorrect){
                      try{
                       Integer.parseInt(iDc);
                       incorrect = false;
                      }
                      catch(NumberFormatException formate){
                      iDc=JOptionPane.showInputDialog("Invalid input,please enter a number withot spaces");
                      }

                    }    
                    if(iDc.isEmpty() || (iDc.trim().isEmpty()) ) {
                     JOptionPane.showMessageDialog(check, "Please Enter the ID of Ticket","Search For Ticket",JOptionPane.PLAIN_MESSAGE);
                    }
                    else if(op.checkIfTicketExist(Integer.valueOf(iDc))==1){
                         int ticketid=0,idspot=0,money=0;
                     String arrive=null,date=null,opname=null,sdescription=null,dep=null,cst=null,plate=null;
                     try{
                      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                      Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "sa3baawy");
                      Statement st = con.createStatement();
                      String sql= "SELECT t.idticket,t.arrivalTime,t.departureTime,t.MoneyToPay,t.dateTicket,op.operatorName,t.iDspot,s.spot_description,c.customerName,c.plateNumber FROM Ticket as t INNER JOIN operators as op on t.idoperator1=op.idoperator INNER JOIN Spot as s on t.iDspot=s.idspot INNER JOIN customers as c on t.idticket=c.iDticket WHERE t.idticket='"+Integer.valueOf(iDc)+"'";
                      ResultSet rs=st.executeQuery(sql);
                      while (rs.next()) {
                          ticketid=rs.getInt(1);
                          arrive=rs.getString(2);
                          dep=rs.getString(3);
                          money=rs.getInt(4);
                          date=rs.getString(5);
                          opname=rs.getString(6);
                          idspot=rs.getInt(7);
                          sdescription=rs.getString(8);
                          cst=rs.getString(9);
                          plate=rs.getString(10);
                      }
                     new FrameInfoTicket(ticketid,arrive,dep,money,date,opname,idspot,sdescription,cst,plate);
                    
                     
                    }catch(Exception e1){
                      System.out.println(e1);
                     }
                        
                    }else{
                      JOptionPane.showMessageDialog(check, "Error","Search For Ticket",JOptionPane.ERROR_MESSAGE);
                    }
                    tidcheck.setText("");
      }}
                    );
                    
tabbedPane.addMouseListener(new MouseListener()  { 

    @Override 
    public void mousePressed(MouseEvent e) { 
      if( tabbedPane.getSelectedIndex()==1){
        
        table=op.viewSpots();
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
       scrollpane.getViewport ().add (table);
      panel1.add(scrollpane);
        }else if (tabbedPane.getSelectedIndex()==2){
          table=op.viewfreeSpots();
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
       scrollpane.getViewport ().add (table);
      panel2.add(scrollpane);
        }
    }

              @Override
              public void mouseClicked(MouseEvent me) {
              }

              @Override
              public void mouseReleased(MouseEvent me) {
              }

              @Override
              public void mouseEntered(MouseEvent me) {
              }

              @Override
              public void mouseExited(MouseEvent me) {
              }
          }
);
 
         jf.setVisible(true);
        jf.setSize(800,560);  
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
          }         
          
         @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==b1){
                op.Logout();
                new BackgroundImageJFrame();
                jf.setVisible(false);
            }}
       

}
