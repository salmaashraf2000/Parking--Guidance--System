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
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class Ticket {
    
    private int id;
    private String arrivalTime;
    private String departureTime;
    private String date;
    private int idSpot;
    private String Operatorname;
    
    Ticket(){
        this.arrivalTime="0";
        this.departureTime="0";
        this.id=1;
      
    }
    public void setOperatorname(String n){
        this.Operatorname=n;
    }
    
    public String getOperatorname(){
        return this.Operatorname;
    }
    
     public void setidSlot(int n){ 
        this.idSpot=n;
    }
    
     public int getidSlot(){
        return this.idSpot;
    }
     
    public void setarrivaltime(String s){
        this.arrivalTime=s;
    }
    
    public void setdeparturetime(String s){
        this.departureTime=s;
    }
   
    public void setDate(){   
	Date date = new Date();
        SimpleDateFormat d=new SimpleDateFormat("yyyy/MM/dd",Locale.US);
        this.date=d.format(date);
    }
    
     public String getdate(){
        return this.date;
    }
     
     public String getarrivalTime(){
        return this.arrivalTime;
    }
     
     public String getdepartureTime(){
         return this.departureTime;
     }
     
     public int getid(){
         return this.id;
     }
}