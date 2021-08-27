/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmergingWorld.JavaClass;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Prashant
 */
public class Dealer_Table {
    SimpleStringProperty Did;
    SimpleStringProperty Dname;
    SimpleStringProperty Dgender;
    SimpleStringProperty Daddr;
    SimpleStringProperty Dcontact;
    SimpleStringProperty Tin;

    public Dealer_Table(String Did, String Dname, String Dgender, String Daddr, String Dcontact, String Tin) {
        this.Did = new SimpleStringProperty(Did);
        this.Dname = new SimpleStringProperty(Dname);
        this.Dgender = new SimpleStringProperty(Dgender);
        this.Daddr = new SimpleStringProperty(Daddr);
        this.Dcontact = new SimpleStringProperty(Dcontact);
        this.Tin = new SimpleStringProperty(Tin);
    }
    public String getDid(){
        return Did.get();
    }
    public String getDname(){
        return Dname.get();
    }
    public String getDgender(){
        return Dgender.get();
    }
    public String getDaddr(){
        return Daddr.get();
    }
    public String getDcontact(){
        return Dcontact.get();
    }
    public String getTin(){
        return Tin.get();
    }
    
    public void setTin(String s){
        this.Tin.set(s);
    }
    public void setDid(String s){
        this.Did.set(s);
    }
    public void setDname(String n){
        this.Dname.set(n);
    }
    
    public void setDgender(String p){
        this.Dgender.set(p);
    }
    public void setDaddr(String p){
        this.Daddr.set(p);
    }
    public void setDcontact(String p){
        this.Dcontact.set(p);
    }
}
