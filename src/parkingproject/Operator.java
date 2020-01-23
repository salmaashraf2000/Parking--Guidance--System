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
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class Operator extends Person implements ILogout{
   
  //return first free spot
   public Spot retrnSpot(){
       Spot s=new Spot();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            Statement st = con.createStatement();
            String sql = "Select TOP 1 * FROM Spot WHERE checkfree=0";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next())
            {
              s.id_spot=rs.getInt(1);
              s.spot_description=rs.getString(2);
              s.check=rs.getInt(3);
            }
            
            s.check=1;
            System.out.println("is slot returned "+s.id_spot);
            String update = "UPDATE Spot SET checkfree=? WHERE idspot='"+s.id_spot+"'"; 
            PreparedStatement pst = con.prepareStatement(update);
            pst.setInt(1,1);
            pst.executeUpdate();
            return s;
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }       
               return null;
               
   } 
   
 
    //check if id and password exist ,if so function returns 1  
    public int login(int id,String password){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
             Statement st = con.createStatement();
 
            String sql = "Select operatorPassword FROM operators WHERE idoperator='"+id+"'";
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
              String y=rs.getString(1);
               if(y.equals(password)){
                 String up = "UPDATE operators SET checkLoggedin=? WHERE idoperator='"+id+"'"; 
                 PreparedStatement pst = con.prepareStatement(up);
                 pst.setInt(1, 1);
                 pst.executeUpdate();
                 return 1; 
              }
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
         return 0;
      
    }
    
    
    //return operator that currently logged in
    public Operator loggedInOperator(){
        Operator op=new Operator();
       
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            Statement st = con.createStatement();
            String sql = "Select * FROM operators WHERE checkLoggedin=1";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next())
            {
                op.id=rs.getInt(1);
                op.name=rs.getString(2);
                op.password=rs.getString(3);
                op.email=rs.getString(4);
                op.phone_number=rs.getString(5);
            }
            
            return op;
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }   
        return null;
    }
    
    //calculate the money customer should pay
    public int calculateMoney(int id,String deptime){
        Ticket t=new Ticket();
        int money=0;
        
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            Statement st = con.createStatement();
            String up="UPDATE Ticket SET departureTime=? WHERE idticket='"+id+"'";
            PreparedStatement pst= con.prepareStatement(up);
            pst.setString(1,deptime);
            pst.executeUpdate();
            String sql = "Select arrivalTime,departureTime FROM Ticket WHERE idticket='"+id+"'";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next())
            {
                t.setarrivaltime(rs.getString(1));
                t.setdeparturetime(rs.getString(2));
            }
           
            String temp=t.getarrivalTime();
            String arrival=temp.substring(0,2);
            temp=t.getdepartureTime();
            String departure=temp.substring(0,2);
            String departurem = temp.substring(3, 5);
            String departures = temp.substring(6);
            int h1 = Integer.valueOf(arrival);
            int h2 =Integer.valueOf(departure);
            int min=Integer.valueOf(departurem);
            int sec=Integer.valueOf(departures);
            
            if(min>0 || sec>0)
            {
              h2++;
            }  
            int TotalHours = h2-h1;
            money=TotalHours*10;
            System.out.println(money);
            try {
                
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con1 = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
                Statement st1 = con1.createStatement();
                String up2="UPDATE Ticket SET MoneyToPay=? WHERE idticket='"+id+"'";
                PreparedStatement pst1= con1.prepareStatement(up2);
                pst1.setInt(1,money);
                pst1.executeUpdate();
                
            } catch (Exception e) {
                
            System.out.println(e);
            } 
    
        } catch (Exception e) {
            
            System.out.println(e);
        }
        return money;
   }

    //free the spot ehen customer leaves
    public void freeSpot(int n){
        
         try {
             
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            String sql = "UPDATE Spot SET checkfree=? WHERE idspot='"+n+"'"; 
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, 0);
            pst.executeUpdate();
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
    }
    
    //check if ticket exists by checking its id
    public int checkIfTicketExist(int id){
        
       try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            Statement st = con.createStatement();
            String sql = "Select 1 From Ticket WHERE idticket='"+id+"'";
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next())
            {
              return 1;
            }
            
       }catch(Exception ex){
           
           System.out.println(ex);
           
       }     
       
       return 0;
   }
   
    
    
    //returns tale that contains all free spots
   JTable viewfreeSpots(){
      
       JTable table=new JTable();
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            Statement st = con.createStatement();
            String s= "SELECT * FROM Spot Where checkfree=0";
            ResultSet rs = st.executeQuery(s);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch(Exception e){
            
            System.out.println(e);
            
        }
         return table;     
    }
   
   
    public int Logout(){
        
         try {
             
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            String sql = "UPDATE operators SET checkLoggedin=? WHERE checkLoggedin=1"; 
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, 0);
            pst.executeUpdate();
            return 1;
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }
        return 0;
        
    }
}


