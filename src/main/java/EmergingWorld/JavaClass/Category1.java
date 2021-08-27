/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmergingWorld.JavaClass;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Prashant
 */
public class Category1 {

     SimpleIntegerProperty rcoun;
     SimpleStringProperty rname;
     SimpleIntegerProperty rquantity;

    public Category1(int rcoun, String rname, int rquantity) {
        this.rcoun = new SimpleIntegerProperty(rcoun);
        this.rname = new SimpleStringProperty(rname);
        this.rquantity = new SimpleIntegerProperty(rquantity);

    }
    public int getRcoun(){
        return rcoun.get();
    }
    public String getRname(){
        return rname.get();
    }
    public int getRquantity(){
        return rquantity.get();
    }
    public void setRcoun(int s){
        this.rcoun.set(s);
    }
    public void setRname(String n){
        this.rname.set(n);
    }
    public void setRquantity(int p){
        this.rquantity.set(p);
    }
    
    
}
