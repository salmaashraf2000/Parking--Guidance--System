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
public class Spot {
    protected int id_spot;
    protected String spot_description;
    protected int check;
    Spot(){
        this.id_spot=0;
        this.spot_description=null;
        this.check=0;
    }
    Spot(String slot_des){
       this.spot_description=slot_des;
       this.check=0;
    }
 
}

