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
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


        
public class ParkingProject {

    /**
     * @param args the command line arguments
     */
  

	
    public static void main(String[] args) {
        // TODO code application logic here
       new BackgroundImageJFrame();
     /* System.out.println("welcome to our project\n");
        Admin a1 = new Admin();
        Admin a2 = new Admin();
        Operator op=new Operator();
        //new test();
        
       // new FrameTicket(0,"hghuhg","iuiuggi","mohammed Ahmed",2,"hgj");
        //op.login(0,"ahmm");
        //op.Logout();
         //a1.DeleteOperator(1);
       // new FrameCustomer();
        //a1.AddSlot("a1");
        //a1.AddSlot("c2");
        //a1.AddSlot("f4");
        //a1.ViewShiftReports();
       //new test();
        /*if(a1.DeleteOperator(0)==1){
            System.out.println("deleted");
       }else{
          System.out.println("not found");
       }
       /*if(a1.UpdateOperator(5)==1){
           a1.updateEmail("updated@gmail.com", 0);
       }else{
          System.out.println("not found");
       }*/
       // a1.AddOperator(0,"ahmed", "ahmood@gmail.com","ahmm", "01472583247");
       // a1.AddOperator(1,"mohamed", "mohamed@gmail.com","mmmhm", "0147258866");
         
         //new FrameCustomer();
       // a2.viewAdmins();
        //int i=a1.AddAdmins(0, "amr", "amr200@gmail.com", "amro", "0100158556");
        //a2.viewAdmins();

        /*a1.AddSlot("3rd row");
        a2.AddSlot("2nd row");
        a2.AddSlot("1st row");
        a2.AddSlot("1st row");
        //a2.viewSlots();
       // a1.viewSlots();*/
        //a1.AddOperator(8, "ahmed", "ahmed200@gmail.com", "ahmoo", "0100152556");
       // a1.AddOperator(9, "mohammed", "ahmed200@gmail.com", "ahmoo", "0100152556");
        //a1.Logout();
       
        //new FrameOperator();
        
       // a1.viewOperators();
        //op.login(8, "ahmoo");
        // op.viewSlots();
        //Operator op1=new Operator();
        
        //op1.loggedInOperator();
       
        /*a2.viewOperators();
        a1.DeleteOperator(0);
         a2.viewOperators();
         a2.UpdateOperator(2);
         a2.viewOperators();
        // Ticket t=new Ticket();*/
         //Customer c1=new Customer();
        // c1.pay(2);
         //c1.pay(3);
         //c1.printTicket("salma","abc123");
       //  System.out.println(c2.pay(7));
         /*Customer c2=new Customer();*/
         //c1.printTicket("ahmed","abc589");
         /*System.out.println();
         Customer c3=new Customer();
         c3.printTicket("mohammed","abc589");
         c2.pay(1);
         c3.pay(2);
        // a1.ViewShiftReports();
        // a2.InfoOfCustemersAndTickets();
         //c3.printt();*/
     
         
    }
    
}

