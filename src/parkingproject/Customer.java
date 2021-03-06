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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Customer {
    protected String name;
    protected String plateNumber;
    
    Customer(){
        this.name=null;
        this.plateNumber=null;
    }
    
    Customer(String name,String platno){
        this.name=name;
        this.plateNumber=platno;
    }
    
    //return id of ticket to be printed in frame
    public int printTicket(String name,String plateno){
        
        Ticket t=new Ticket();
        Operator optr=new Operator();
        Customer c1 =new Customer(name,plateno);
        optr=optr.loggedInOperator(); 
        if(optr.name==null)
        {
            return 0;
        }
        Spot s =optr.retrnSpot();
        System.out.println(s.id_spot);
        int tt=0;
        
        if(s==null)
        {
            System.out.println("Sorry,all spots are full");
            return 0;
        }
        
        t.setDate();
        t.setarrivaltime(calcTime());
        t.setidSlot(s.id_spot);
        t.setOperatorname(optr.name);
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
            String insert="INSERT INTO Ticket(arrivalTime,dateTicket,idoperator1,iDspot) OUTPUT INSERTED.idticket VALUES (?,?,?,?)";
            PreparedStatement pst= con.prepareStatement(insert);
            pst.setString(1,t.getarrivalTime());
            pst.setString(2,t.getdate());
            pst.setInt(3,optr.id);
            pst.setInt(4,s.id_spot);
            ResultSet rs = pst.executeQuery();
        
            if(rs.next())
            {
                 tt=rs.getInt(1);
            }
            
            String insertc="INSERT INTO customers(customerName,plateNumber,IDticket) VALUES (?,?,?)";
            PreparedStatement pstc= con.prepareStatement(insertc);
            pstc.setString(1,c1.name);
            pstc.setString(2,c1.plateNumber);
            pstc.setInt(3,tt);
            pstc.executeUpdate();
            
        } catch (Exception e) {
            
            System.out.println(e);
        }   
        return (tt);
    }
    
    
    //return money customer should pay
    public int pay(int ticketId){
        
        int money=0,sspot=0;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QHUMP83:1433;databaseName=ParkingProject", "parking", "parking");
             Statement st = con.createStatement();
            String sql = "Select 1 From Ticket WHERE idticket='"+ticketId+"'";
            ResultSet rs = st.executeQuery(sql);
            
            if(!rs.next())
            {
                 return 0;
            }
          
            Operator optr=new Operator();
            String select = "Select iDspot From Ticket WHERE idticket='"+ticketId+"'";
            ResultSet r = st.executeQuery(select);
        
            if(r.next())
            {
                sspot=r.getInt(1);
            } 
            money=optr.calculateMoney(ticketId,calcTime());
            optr.freeSpot(sspot);
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }
     
     return money;
    }
    
    
    //calculate current time
    public String calcTime(){
        Date date= new Date();
        SimpleDateFormat d=new SimpleDateFormat("hh:mm:ss",Locale.US);
        return d.format(date);
    }
    
}
