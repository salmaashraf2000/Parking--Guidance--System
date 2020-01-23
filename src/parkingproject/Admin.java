/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingproject;

/**
 *
 * @author 
 */

import java.util.*;
import java.io.*;
import java.sql.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Admin extends Person implements ILogout{
     
     
     Admin()
     {
        
     }
     
     
    //add spot for parking 
    void AddSpot(String spot_description){ 
       Spot s=new Spot(spot_description);
       s.check=0;
       
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            String insertSlot="INSERT INTO Spot (spot_description,checkfree) VALUES (?,?)";
            PreparedStatement pst= con.prepareStatement(insertSlot);
            pst.setString(1,s.spot_description);
            pst.setInt(2,s.check);
            pst.executeUpdate();
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }       
        
    }
    
    //add information of operator
    int AddOperator(int iD,String name,String email,String password,String phone_number){
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            Statement st = con.createStatement();
            String sql = "Select 1 From operators WHERE idoperator='"+iD+"'";
            ResultSet rs = st.executeQuery(sql);
            
            if(!rs.next())
            {
                Operator op= new Operator();
                op.id=iD;
                op.name=name;
                op.password=password;
                op.email=email;
                op.phone_number=phone_number;
                String insertSlot="INSERT INTO operators (idoperator,operatorName,email,operatorPassword,phone_number,checkLoggedin) VALUES (?,?,?,?,?,?)";
                PreparedStatement pst= con.prepareStatement(insertSlot);
                pst.setInt(1,op.id);
                pst.setString(2,op.name);
                pst.setString(3,op.email);
                pst.setString(4,op.password);
                pst.setString(5,op.phone_number);
                pst.setInt(6,0);
                pst.executeUpdate();
                return 1;
                
            }
        } catch (Exception e) {
            
            System.out.println(e);
            
        }
                return 0;    
            
    }
    
    //check if operator exists to update information
    int UpdateOperator(int id){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            Statement st = con.createStatement();
            String sql = "Select 1 From operators WHERE idoperator='"+id+"'";
            ResultSet rs = st.executeQuery(sql);
            
            if(!rs.next())
            {
                return 0;
                
            }else
            {
                return 1;
                
            }
        }catch(Exception e){ 
            
            System.out.println(e);
            return 0;
            
        }
             
    
}
        
        
     //check if operator exists using id , if exists delete it          
    int DeleteOperator(int id){
        
       try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            Statement st = con.createStatement();
            String sql = "Select 1 From operators WHERE idoperator='"+id+"'";
            ResultSet rs = st.executeQuery(sql);
            
            if(!rs.next())
            {
                return 0; 
                
            }else
            {
                
              Statement std= con.createStatement();
              String delete ="DELETE FROM operators WHERE idoperator='"+id+"'";
              std.executeUpdate(delete);
              return 1;
              
            }
        }catch(Exception e){ 
            
            System.out.println(e);
            return 0;
            
        }     
    }
    
    
    //return jtable that contains profit of each day
    JTable ViewShiftReports(){
        
        JTable table=new JTable();
        
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            Statement st = con.createStatement();
            String sql = "(SELECT t1.dateTicket , sum(t1.MoneyToPay) ProfitOfDay from Ticket t1 INNER JOIN Ticket t2 ON t1.dateTicket = t2.dateTicket   and t1.idticket!=t2.idticket and t1.MoneyToPay!=NULL GROUP BY t1.dateTicket) UNION (select t1.dateTicket ,sum(t1.MoneyToPay)  from Ticket t1 INNER JOIN Ticket t2 ON t1.idticket=t2.idticket GROUP BY t1.dateTicket)";         
            ResultSet rs = st.executeQuery(sql);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }
         
         return table;
    }
    
    
    //check if id and password exist , if so function returns 1
    public int login(int id,String password){ 
        
          try {
              
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            Statement st = con.createStatement(); 
            String sql = "Select adminPassword FROM admins WHERE idadmin='"+id+"'";
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next())
            {
               String y=rs.getString(1);
               
               if(y.equals(password))
               {
                 return 1; 
               }
            }
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }
        return 0;   
    } 
    
    
    //update email of operator 
   void updateEmail(String email,int id){
       
         try {
             
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            String sql = "UPDATE operators SET email=? WHERE idoperator='"+id+"'"; 
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.executeUpdate();
            
        }catch(Exception e){  
            
            System.out.println(e);
       
        }
    }
   
   //update phone number of operator
    void updatePhone(String phone,int id){
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            String sql = "UPDATE operators SET phone_number=? WHERE idoperator='"+id+"'"; 
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, phone);
            pst.executeUpdate();
            
        }catch(Exception e){
            
            System.out.println(e);
       
        }
    }
    
    //returns jtable that contains information of all tickets and customers
    JTable InfoOfCustemersAndTickets(){
        
        JTable table=new JTable();
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            Statement st = con.createStatement();
            String s= "SELECT t.idticket,t.arrivalTime,t.departureTime,t.dateTicket,t.iDspot,t.MoneyToPay,op.operatorName,c.customerName,c.plateNumber FROM Ticket as t  INNER JOIN customers as c on t.idticket=c.IDticket LEFT JOIN operators as op on t.idoperator1=op.idoperator ORDER BY t.idticket";
            ResultSet rs = st.executeQuery(s);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch(Exception e){
            
            System.out.println(e);
            
        }
        return table;
       
    }
    
    
    //add information of new admin
    int AddAdmins(int iD,String name,String email,String password,String phone_number){
        
       try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            Statement st = con.createStatement();
            String sql = "Select 1 From admins WHERE idadmin='"+iD+"'";
            ResultSet rs = st.executeQuery(sql);
            
            if(!rs.next())
            {
                Admin ad=new Admin();
                ad.id=iD;
                ad.name=name;
                ad.password=password;
                ad.email=email;
                ad.phone_number=phone_number;
                String insertSlot="INSERT INTO admins (idadmin,adminName,email,adminPassword,phone_number) VALUES (?,?,?,?,?)";
                PreparedStatement pst= con.prepareStatement(insertSlot);
                pst.setInt(1,ad.id);
                pst.setString(2,ad.name);
                pst.setString(3,ad.email);
                pst.setString(4,ad.password);
                pst.setString(5,ad.phone_number);
                pst.executeUpdate();
                return 1;
            }
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }
        return 0;    
       
    } 
    
    
    //returns jtable that contains information of all admins
    JTable viewAdmins(){ 
        JTable table=new JTable();
        DefaultTableModel dm = new DefaultTableModel(new String[]{"Admin ID", "Admin Name", "Email","Admin Password","Phone Number"}, 0);
        
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            Statement st = con.createStatement();
            String sql= "SELECT * FROM admins";
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next())
            {
                dm.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
            }
            
            table.setModel(dm);
    }catch(Exception e){
        
        System.out.println(e);
        
    }   
    return table;
    }
    
    //returns jtable that contains information of all operators
    JTable viewOperators(){
        
        JTable table=new JTable();
        DefaultTableModel dm = new DefaultTableModel(new String[]{"Operator ID", "Operator Name", "Email","Operator Password","Phone Number","Check Logedin"}, 0);
      
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            Statement st = con.createStatement();
            String sql= "SELECT * FROM operators";
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()) 
            {
                dm.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)});
            }
            
            table.setModel(dm);
    }catch(Exception e){
        
        System.out.println(e);
        
    }   
    return table;
    }
    
    
   public int Logout(){
       return 1;
   } 
    
}

