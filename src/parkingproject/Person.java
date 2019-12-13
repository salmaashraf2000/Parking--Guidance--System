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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
public abstract class Person {
    protected int id;
    protected String name;
    protected String email;
    protected String password;
    protected String phone_number;
    
    public abstract int login(int id,String password);
   // public abstract int Logout();
    JTable viewSpots(){
       /* for(Slot s:slots){
            
            System.out.println("Slot number:"+ s.id_slot+" Row Number: "+s.slot_description+"Empty: "+s.check);
        }*/
       JTable table=new JTable();
         try{
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "sa3baawy");
             Statement st = con.createStatement();
        String s= "SELECT * FROM Spot";
        ResultSet rs = st.executeQuery(s);
       table.setModel(DbUtils.resultSetToTableModel(rs));
        
    }catch(Exception e){
        System.out.println(e);
    }
         return table;
       
    }
   
}
